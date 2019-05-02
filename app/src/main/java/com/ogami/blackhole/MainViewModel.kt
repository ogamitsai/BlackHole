package com.ogami.blackhole

import android.util.Log
import androidx.lifecycle.viewModelScope
import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.base.BaseViewModel
import com.ogami.commonlib.coroutine.*
import com.ogami.commonlib.http.ApiFactory
import com.ogami.commonlib.http.await
import com.ogami.commonlib.http.request
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.Default
import kotlin.system.measureTimeMillis


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

//        runBlocking {
//            val handler = CoroutineExceptionHandler { _, exception ->
//                LogUtils.tag("ogami").i("Caught $exception")
//            }
//            val job = GlobalScope.launch {
//                launch { // 第一个子协程
//                    try {
//                        delay(Long.MAX_VALUE)
//                    } finally {
//                        withContext(NonCancellable) {
//                            LogUtils.tag("ogami").i("Children are cancelled, but exception is not handled until all children terminate")
//                            delay(100)
//                            LogUtils.tag("ogami").i("The first child finished its non cancellable block")
//                        }
//                    }
//                }
//                launch { // 第二个子协程
//                    delay(10)
//                    LogUtils.tag("ogami").i("Second child throws an exception")
//                    throw ArithmeticException()
//                }
//            }
//            job.join()
//        }


        launchTask {

        }

        asyncTask{

        }
    }


}