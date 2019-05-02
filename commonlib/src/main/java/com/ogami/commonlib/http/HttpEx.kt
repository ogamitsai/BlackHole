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


inline fun BaseViewModel.request(noinline block: suspend CoroutineScope.() -> Unit) = vmScope.async(block = block)


suspend fun <T> Call<T>.await(): T = suspendCoroutine {
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