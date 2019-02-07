[![Release](https://jitpack.io/v/Qase/PermissionManager.svg)](https://jitpack.io/#Qase/PermissionManager)
[![Build Status](https://travis-ci.org/Qase/PermissionManager.svg?branch=master)](https://travis-ci.org/Qase/PermissionManager)
[![codebeat badge](https://codebeat.co/badges/ca498e22-a499-4e33-a510-da6050b31ab3)](https://codebeat.co/projects/github-com-qase-permissionmanager-master)
[![API](https://img.shields.io/badge/API-16%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=16)
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)
[![Maintainer: kidal5](https://img.shields.io/badge/Maintainer-kidal5-blue.svg)](mailto:vladislav.trnka@quanti.cz)
[![Qase: PermissionManager](https://img.shields.io/badge/Qase-PermissionManager-ff69b4.svg)](https://github.com/Qase/PermissionManager)

## PermissionManager

Smart android runtime permission manager written in kotlin language.

Mostly used and tested in Prague based android develpoment company - [Quanti](https://www.quanti.cz/).

Do not use it right now. There might be bugs inside because of new android versions.

## Features
* Usable in every JVM language including Java/Kotlin/Scala ...
* Very easy to use
* Lightweight
* Sample [app](github/gra.png) is ready to build 

## Cons
* Need static access to activity

## Code Example

Usage is simple

1) Add all your desired permissions to manifest

```xml
<manifest ...>
    <uses-permission android:name="android.permission.READ_CALENDAR"/>
    <uses-permission android:name="android.permission.SEND_SMS"/>
    <uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
    
    ...
    
</manifest>
```

2) Add some code to your static activity

```kotlin
 override fun onCreate(savedInstanceState: Bundle?) {
       BasePermission.setActivity(this)
 }
    
 override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<String>, grantResults: IntArray) {
       BasePermission.propagatePermissionResult(requestCode, permissions, grantResults)
 }
```
3) Then select appropriate instance based on [permission class](https://developer.android.com/guide/topics/permissions/overview.html#perm-groups) and ask for permission or check status
```kotlin
 if (ContactsPermission.permissionState == DECLINED){
       ContactsPermission.requestPermission(this)
 }
                
 if (ContactsPermission.permissionGranted())
```


## Installation

Follow this [STEPS](https://jitpack.io/#Qase/PermissionManager).

## Future development
* send your requests

## License

Copyright 2018 Quanti s.r.o

Licensed under the Apache License, Version 2.0 (the “License”); you may not use this file except in compliance with the License. You may obtain a copy of the License at 

http://www.apache.org/licenses/LICENSE-2.0 

Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an “AS IS” BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.
