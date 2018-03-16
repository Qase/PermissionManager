package quanti.com.permissionmanager

import android.Manifest
import android.os.Build
import android.support.annotation.RequiresApi
import quanti.com.permissionmanager.base.BasePermission

@RequiresApi(Build.VERSION_CODES.KITKAT_WATCH)

object SensorsPermission : BasePermission(Manifest.permission.BODY_SENSORS)

