package com.ogami.commonlib.arouter

import android.app.Application
import android.content.Context
import com.alibaba.android.arouter.launcher.ARouter
import com.ogami.commonlib.BuildConfig

/**
 *@description 页面跳转扩展函数
 *
 *@author Ogami
 *
 *@create 2019-04-28 18:20
 **/

fun Application.initArouter() {

    if (BuildConfig.DEBUG){
        ARouter.openDebug()
        ARouter.openLog()
    }

    ARouter.printStackTrace()
    ARouter.init(this)
}

fun Context.startActivityByARouter(path: String) {
    ARouter.getInstance().build(path).navigation()
}


fun Application.destroyArouter(){
    ARouter.getInstance().destroy()

}