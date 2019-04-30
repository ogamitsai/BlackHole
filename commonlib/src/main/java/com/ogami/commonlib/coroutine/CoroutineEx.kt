package com.ogami.commonlib.coroutine

import com.apkfuns.logutils.LogUtils
import kotlinx.coroutines.*
import kotlin.coroutines.suspendCoroutine

/**
 *@description 封装的协程库
 *
 *@author Ogami
 *
 *@create 2019-04-28 20:15
 **/


//协程调度器 内置3个线程供调度
val coroutineDispatcher = newFixedThreadPoolContext(3, "BlackholeThread")

inline fun launch(delayTime: Long = 0, noinline job: suspend () -> Unit){
//    CoroutineScope(){
//
//    }
}

inline fun <T> launchGlobal(delayTime: Long = 0, noinline job: suspend () -> T) =
    GlobalScope.launch(coroutineDispatcher) {
        delay(delayTime)
        job()
    }

inline fun <T> asyncGlobal(delayTime: Long = 0, noinline job: suspend () -> T) =
    GlobalScope.async(coroutineDispatcher) {
        delay(delayTime)
        job()
    }


inline fun <T> taskOnMainThread(noinline job: suspend () -> T) = runBlocking(Dispatchers.Main) {
    job()
}


inline fun tryCatch(catchBlock: (Throwable) -> Unit = {}, tryBlock: () -> Unit) {
    try {
        tryBlock()
    } catch (t: Throwable) {
        catchBlock(t)
    }
}


//阻塞当前线程
inline fun blocking() {

//    withContext{
//
//    }
}
