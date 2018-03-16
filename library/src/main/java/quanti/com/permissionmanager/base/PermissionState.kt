package quanti.com.permissionmanager.base

/**
 * Created by Trnka Vladislav on 16.02.2018.
 *
 */
enum class PermissionState
{
    /**
     * User has granted access to permission
     */
    GRANTED,

    /**
     * User has declined access to permission
     *
     * user did NOT check "never ask again"
     * this is a good place to explain the user
     * why you need the permission and ask if he wants
     * to accept it (the rationale)
     */
    DECLINED,

    /**
     * User has declined access to permission and checked "never ask again"
     *
     * you can either enable some fall back,
     * disable features of your app
     * or open another dialog explaining
     * again the permission and directing to the app setting
     */
    DECLINED_FOR_EVER
}