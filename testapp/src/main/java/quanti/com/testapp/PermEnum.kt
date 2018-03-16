package quanti.com.testapp

import quanti.com.permissionmanager.*
import quanti.com.permissionmanager.base.BasePermission

enum class PermEnum {
    Calendar,
    Cam,
    Cont,
    Loc,
    Mic,
    Phone,
    Sens,
    Sms,
    Stor;

    fun getImgResourceId(): Int {
        return when (this) {
            PermEnum.Calendar -> R.drawable.ic_perm_contact_calendar
            PermEnum.Cam -> R.drawable.ic_videocam
            PermEnum.Cont -> R.drawable.ic_contacts
            PermEnum.Loc -> R.drawable.ic_location_on
            PermEnum.Mic -> R.drawable.ic_perm_camera_mic
            PermEnum.Phone -> R.drawable.ic_local_phone
            PermEnum.Sens -> R.drawable.ic_terrain
            PermEnum.Sms -> R.drawable.ic_sms
            PermEnum.Stor -> R.drawable.ic_sd_card
        }
    }

    fun getTitleResourceId(): Int {
        return when (this) {
            PermEnum.Calendar -> R.string.calendar
            PermEnum.Cam -> R.string.camera
            PermEnum.Cont -> R.string.contacts
            PermEnum.Loc -> R.string.location
            PermEnum.Mic -> R.string.mic
            PermEnum.Phone -> R.string.phone
            PermEnum.Sens -> R.string.sens
            PermEnum.Sms -> R.string.sms
            PermEnum.Stor -> R.string.stor
        }
    }

    fun getSubtitleResourceId(): Int {
        return when (this) {
            PermEnum.Calendar -> R.string.calendar_subtitle
            PermEnum.Cam -> R.string.camera_subtitle
            PermEnum.Cont -> R.string.contacts_subtitle
            PermEnum.Loc -> R.string.location_subtitle
            PermEnum.Mic -> R.string.mic_subtitle
            PermEnum.Phone -> R.string.phone_subtitle
            PermEnum.Sens -> R.string.sens_subtitle
            PermEnum.Sms -> R.string.sms_subtitle
            PermEnum.Stor -> R.string.stor_subtitle
        }
    }

    fun getPermissionInstance() : BasePermission {
        return when (this) {
            PermEnum.Calendar -> CalendarPermission
            PermEnum.Cam -> CameraPermission
            PermEnum.Cont -> ContactsPermission
            PermEnum.Loc -> LocationPermission
            PermEnum.Mic -> MicrophonePermission
            PermEnum.Phone -> PhonePermission
            PermEnum.Sens -> SensorsPermission
            PermEnum.Sms -> SmsPermission
            PermEnum.Stor -> StoragePermission
        }
    }


}