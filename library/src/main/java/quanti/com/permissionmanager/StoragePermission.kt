package quanti.com.permissionmanager

import android.Manifest
import quanti.com.permissionmanager.base.BasePermission


object StoragePermission : BasePermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)