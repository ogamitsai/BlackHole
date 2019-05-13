package com.ogami.commonlib.http

import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory


/**
 *@description Retrofit封装
 *
 *@author Ogami
 *
 *@create 2019-04-29 11:27
 **/

class ApiFactory {

    //CoroutineCallAdapterFactory
    val mRetrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("http://gank.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    companion object {
        val INSTANCE: ApiFactory by lazy(mode = LazyThreadSafetyMode.SYNCHRONIZED) { ApiFactory() }
    }

    fun <T>createApi(clazz : Class<T>) = mRetrofit.create(clazz)


}