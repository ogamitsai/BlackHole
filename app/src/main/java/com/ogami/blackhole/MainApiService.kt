package com.ogami.blackhole

import com.ogami.commonlib.http.ApiService
import retrofit2.Call
import retrofit2.http.GET

/**
 * @description
 * @author Ogami
 * @create 2019-04-30 15:23
 **/

interface MainApiService  {

    @GET("data/iOS/2/1")
    fun getIOSGank(): Call<GankResult>

    @GET("data/Android/2/1")
    fun getAndroidGank(): Call<GankResult>
}