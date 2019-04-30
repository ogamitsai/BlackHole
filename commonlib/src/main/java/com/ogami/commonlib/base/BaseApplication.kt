package com.ogami.commonlib.base

import android.app.Application
import android.content.ComponentCallbacks2
import android.content.Context
import androidx.multidex.MultiDex
import com.bumptech.glide.Glide
import com.ogami.commonlib.arouter.destroyArouter
import com.ogami.commonlib.base.config.AppConfig


/**
 *@description
 *
 *@author Ogami
 *
 *@create 2019-04-28 18:25
 **/

open class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        AppConfig.initConfig(this)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)

    }


    //程序终止时
    override fun onTerminate() {
        super.onTerminate()

        destroyArouter()
    }


    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

        if (level == ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory()
        }
        // trim memory
        Glide.get(this).trimMemory(level)
    }

    override fun onLowMemory() {
        super.onLowMemory()
        // low memory clear Glide cache
        Glide.get(this).clearMemory()
    }

}