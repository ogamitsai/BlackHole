package com.ogami.commonlib.base.config

import android.app.Application
import com.ogami.commonlib.arouter.initArouter

object AppConfig {


    fun initConfig(application: Application){

        application.initArouter()
    }
}