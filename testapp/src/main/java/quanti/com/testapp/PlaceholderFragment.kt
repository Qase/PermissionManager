package quanti.com.testapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_main.*
import kotlinx.android.synthetic.main.fragment_main.view.*
import quanti.com.permissionmanager.base.BasePermission
import quanti.com.permissionmanager.base.IPermissionResult
import quanti.com.permissionmanager.base.PermissionState
import quanti.com.permissionmanager.base.PermissionState.*

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment(), IPermissionResult, View.OnClickListener  {


    lateinit var perm : BasePermission

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val permType = arguments.getSerializable(PERM_TYPE) as PermEnum
        perm = permType.getPermissionInstance()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_main, container, false)

        val permType = arguments.getSerializable(PERM_TYPE) as PermEnum

        val img = permType.getImgResourceId()
        val title = permType.getTitleResourceId()
        val subtitle = permType.getSubtitleResourceId()

        rootView.image.setImageResource(img)
        rootView.title.setText(title)
        rootView.subtitle.setText(subtitle)
        rootView.state.text = perm.permissionState.name

        rootView.got_it_button.setOnClickListener(this)
        return rootView
    }

    override fun onClick(p0: View?) {
        when(perm.permissionState){
            GRANTED -> Toast.makeText(context, "No need to ask, you already have that permission.", Toast.LENGTH_LONG).show()
            DECLINED -> perm.requestPermission(this)
            DECLINED_FOR_EVER -> startActivity(BasePermission.getPermissionSettingsIntent(BuildConfig.APPLICATION_ID))
        }
    }

    override fun onPermissionChange(permissionName: String, result: PermissionState) {
        state.text = result.name
    }



    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val PERM_TYPE = "alskdj"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        fun newInstance(perm: PermEnum): PlaceholderFragment {
            val fragment = PlaceholderFragment()
            val args = Bundle()
            args.putSerializable(PERM_TYPE, perm)
            fragment.arguments = args
            return fragment
        }
    }
}