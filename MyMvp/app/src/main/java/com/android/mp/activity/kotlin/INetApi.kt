package com.android.mp.activity.kotlin

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface INetApi {
    @GET("")
    suspend fun getBaidu(@Url url:String ="https://www.baidu.com"): Response<String>
}