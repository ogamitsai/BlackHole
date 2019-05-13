package com.ogami.commonlib.rx

import com.apkfuns.logutils.LogUtils
import com.ogami.commonlib.http.exception.ApiException
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.json.JSONException
import org.json.JSONObject
import retrofit2.Response
import java.util.concurrent.TimeUnit

/**
 * Created by ogami on 2018/5/9.
 */


fun <T> Single<T>.async(withDelay: Long = 0): Single<T> =
    this.subscribeOn(Schedulers.io()).delay(withDelay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())

fun <T> Observable<T>.async(withDelay: Long = 0): Observable<T> =
    this.subscribeOn(Schedulers.io()).delay(withDelay, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread())


inline fun <reified T> Single<Response<BaseResponce<T>>>.handleResult(
    noinline onSuccess: (T) -> Unit,
    crossinline onError: (Pair<Int, String>) -> Unit
) {
    this.compose { upstream ->
        upstream.flatMap<BaseResponce<T>> {
            if (it.isSuccessful) {
                Single.just(it.body())
            } else {
                Single.error<BaseResponce<T>>(ApiException(it.message(), it.code()))
            }
        }
    }.compose { upstream ->
        upstream.flatMap {

            if (it.code == 0) {
                Single.just(it.data)
            } else {
                Single.error<T>(ApiException(it.message, code = it.code))
            }
        }
    }.subscribeEx(onSuccess, onError)
}

inline fun <reified T> Single<T>.subscribeEx(
    noinline onSuccess: (T) -> Unit,
    crossinline onError: (Pair<Int, String>) -> Unit
) {
    subscribe(Consumer(onSuccess), Consumer {
        LogUtils.tag("ogami").i(it)
        onError(111 to "???")
    })
}


data class BaseResponce<T>(val code: Int, val message: String, val data: T)
