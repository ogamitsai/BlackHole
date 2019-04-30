package com.ogami.commonlib.http

import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.base.BaseViewModel
import com.ogami.commonlib.coroutine.coroutineDispatcher
import com.ogami.commonlib.coroutine.launchGlobal
import com.ogami.commonlib.coroutine.tryCatch
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

/**
 *@description
 *
 *@author Ogami
 *
 *@create 2019-04-29 15:43
 **/


inline fun <T> BaseViewModel.request(noinline block: suspend CoroutineScope.() -> T) {
    httpScope.launch {
        try {
            withContext(context = Dispatchers.Main, block = block)
        } catch (e: Exception) {
            LogUtils.tag("ogami").i(e)
        } finally {

        }
    }

}

suspend fun <T> Call<T>.await(): T {
    return suspendCoroutine {
        enqueue(object : Callback<T> {
            override fun onFailure(call: Call<T>, t: Throwable) {
                it.resumeWithException(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                if (response.isSuccessful) {
                    it.resume(response.body()!!)
                } else {
                    it.resumeWithException(Throwable(response.toString()))
                }
            }
        })
    }
}