package com.ogami.commonlib.arouter

import android.app.Application
import android.content.Context
import android.util.Log
import com.alibaba.android.arouter.facade.Postcard
import com.alibaba.android.arouter.facade.callback.NavCallback
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
    ARouter.getInstance().build(path).navigation(this, object : NavCallback() {
        override fun onArrival(postcard: Postcard?) {
            Log.d("MainActivity", "onArrival : " + postcard?.getPath())
        }


        override fun onInterrupt(postcard: Postcard) {  //路由被拦截时调用
            Log.d("MainActivity", "onInterrupt : " + postcard.path)
        }

        override fun onLost(postcard: Postcard) {   //路由被丢失时调用
            Log.d("MainActivity", "onLost : " + postcard.path)
        }

        override fun onFound(postcard: Postcard) {  //路由目标被发现时调用
            Log.d("MainActivity", "onFound : " + postcard.path)
        }
    })
}


fun Application.destroyArouter(){
    ARouter.getInstance().destroy()

}