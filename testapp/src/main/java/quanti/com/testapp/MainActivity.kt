package quanti.com.testapp

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import quanti.com.permissionmanager.base.BasePermission

class MainActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: SectionsPagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mSectionsPagerAdapter = SectionsPagerAdapter(supportFragmentManager)

        container.setPageTransformer(false, FragmentTransformer())

        // Set up the ViewPager with the sections adapter.
        container.adapter = mSectionsPagerAdapter

        BasePermission.setActivity(this)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        BasePermission.propagatePermissionResult(requestCode, permissions, grantResults)
    }

    inner class SectionsPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return PlaceholderFragment.newInstance(PermEnum.values()[position])
        }

        override fun getCount(): Int {
            // Show 3 total pages.
            return PermEnum.values().size
        }
    }


}
