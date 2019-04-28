package com.ogami.commonlib.base

import android.app.Application
import android.content.Context
import androidx.multidex.MultiDex
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

}