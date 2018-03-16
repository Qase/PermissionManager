package quanti.com.permissionmanager.base

/**
 * Created by Trnka Vladislav on 15.02.2018.
 *
 */
interface IPermissionResult
{
    /**
     * @param permissionName name of permission
     * @param result result of operation
     */
    fun onPermissionChange(permissionName: String, result: PermissionState)
}