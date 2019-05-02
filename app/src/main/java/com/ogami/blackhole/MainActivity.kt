package com.ogami.blackhole

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.android.startActivityByEx
import com.ogami.commonlib.base.BaseActivity
import com.ogami.commonlib.http.ApiService
import com.ogami.commonlib.http.ApiFactory

/**
 *  第一个 个人App 刚好发布第一张黑洞照片 所以取名叫黑洞
 */
class MainActivity : BaseActivity() {


    val vm by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        launch{
//            LogUtils.tag("ogami").i(Thread.currentThread().name)
//        }

        vm.testmScope()

//        if (!isStart){
//            finish()
//            isStart = !isStart
//            startActivityByEx<SecondActivity>()
//
//        }else{
//        }





    }



}
