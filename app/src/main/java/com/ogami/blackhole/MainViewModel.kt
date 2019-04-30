package com.ogami.blackhole

import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.base.BaseViewModel
import com.ogami.commonlib.coroutine.launch
import com.ogami.commonlib.http.ApiFactory
import com.ogami.commonlib.http.await
 import com.ogami.commonlib.http.request
import kotlinx.coroutines.*


/**
 * @description
 * @author Ogami
 * @create 2019-04-30 12:13
 **/
class MainViewModel : BaseViewModel() {


    val api by lazy { ApiFactory.INSTANCE.createApi(MainApiService::class.java) }


    fun testmScope() {

//       request {
//           val result = api.getIOSGank().await().results
//           LogUtils.tag("ogami").i(result)

//           LogUtils.tag("ogami").i(Thread.currentThread().name)
//
//       }


        vmScope.launch {
            LogUtils.tag("ogami").i(Thread.currentThread().name)
        }

        request {
            LogUtils.tag("ogami").i(Thread.currentThread().name)

        }



    }


}