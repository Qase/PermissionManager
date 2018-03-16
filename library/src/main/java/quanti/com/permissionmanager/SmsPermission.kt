package quanti.com.permissionmanager

import android.Manifest
import quanti.com.permissionmanager.base.BasePermission


object SmsPermission: BasePermission(Manifest.permission.SEND_SMS)
