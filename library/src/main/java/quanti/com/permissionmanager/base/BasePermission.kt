package quanti.com.permissionmanager.base

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat

/**
 * Created by Trnka Vladislav on 14.02.2018.
 *
 * https://stackoverflow.com/questions/32822101/how-to-programmatically-open-the-permission-screen-for-a-specific-app-on-android
 * https://stackoverflow.com/a/31925748
 *
 * Base class for handling permission
 *
 * WHEN DERIVING FROM THIS CLASS, YOU NEED TO CALL ON_REQUEST_PERMISSION_RESULT METHOD
 */

/**
 * @param permissionName android.Manifest.permission name of permission
 */
abstract class BasePermission(
        @Suppress("MemberVisibilityCanBePrivate") val permissionName: String
) {
    private val requestValue: Int = requestNumber

    @Suppress("MemberVisibilityCanBePrivate")
    var permissionState = if (ContextCompat.checkSelfPermission(staticActivity, permissionName) == PackageManager.PERMISSION_GRANTED) {
        PermissionState.GRANTED
    } else {
        PermissionState.DECLINED
    }

    init {
        listOfInstances.add(this)
    }

    /**
     * permissionState == PermissionState.GRANTED
     * @return true when user has granted this permission
     */
    fun permissionGranted() = permissionState == PermissionState.GRANTED

    private var callback: IPermissionResult? = null

    /**
     * Request permission
     *
     * @param callback result of action
     */
    fun requestPermission(callback: IPermissionResult) {
        this.callback = callback

        ActivityCompat.requestPermissions(
                staticActivity,
                arrayOf(permissionName),
                requestValue)

    }


    /**
     * Method, that needs to be propagated from Activity to everything work
     */
    protected fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
        if (requestCode != requestValue)
            return

        // If request is cancelled, the result arrays are empty.
        permissionState = if (grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            PermissionState.GRANTED
        } else if (!ActivityCompat.shouldShowRequestPermissionRationale(staticActivity, permissionName)) //pay attention to negate sign
        {
            PermissionState.DECLINED_FOR_EVER
        } else {
            PermissionState.DECLINED
        }
        callback?.onPermissionChange(permissionName, permissionState)
        callback = null
    }


    companion object {
        private var listOfInstances = ArrayList<BasePermission>()

        private var requestNumber: Int = 985
            get() {
                field++
                return field
            }

        @JvmStatic
                /**\
                 * @param appId BuildConfig.APPLICATION_ID)
                 */
        fun getPermissionSettingsIntent(appId: String): Intent {
            val intent = Intent()
            intent.action = android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS
            intent.data = Uri.parse("package:$appId")
            return intent
        }

        @JvmStatic
        fun propagatePermissionResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
            listOfInstances.forEach {
                it.onRequestPermissionsResult(requestCode, permissions, grantResults)
            }
        }


        private lateinit var staticActivity: Activity

        fun setActivity(activity: Activity) {
            staticActivity = activity
        }
    }

}
