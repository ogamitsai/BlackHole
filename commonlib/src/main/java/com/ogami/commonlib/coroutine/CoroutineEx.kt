package com.ogami.commonlib.coroutine

import com.apkfuns.logutils.LogUtils
import kotlinx.coroutines.*
import java.lang.IndexOutOfBoundsException
import kotlin.coroutines.suspendCoroutine

/**
 * @description 封装的协程库
 * @author Ogami
 * @create 2019-04-28 20:15
 **/


//协程调度器 内置3个线程供调度
val coroutineDispatcher = newFixedThreadPoolContext(3, "BlackholeThread")

val taskScope: CoroutineScope by lazy {
    CoroutineScope(coroutineDispatcher)
}

inline fun launchTask(delayTime: Long = 0, noinline job: suspend () -> Unit) =
    taskScope.launch {
        delay(delayTime)
        job()
    }

inline fun asyncTask(delayTime: Long = 0, noinline job: suspend () -> Unit) =
    taskScope.async {
        delay(delayTime)
        job()
    }

inline fun launchOnUI(noinline block: suspend CoroutineScope.() -> Unit) =
    taskScope.launch(context = Dispatchers.Main, block = block)

inline fun launchChildTask(noinline block: suspend CoroutineScope.() -> Unit) = taskScope.launch(block = block)

inline fun asyncChildTask(noinline block: suspend CoroutineScope.() -> Unit) = taskScope.async(block = block)

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


fun Deferred<Any>?.cancelByActive() = this?.run {
    tryCatch {
        if (isActive) {
            cancel()
        }
    }
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

    runBlocking { }
//    withContext{
//
//    }
}
