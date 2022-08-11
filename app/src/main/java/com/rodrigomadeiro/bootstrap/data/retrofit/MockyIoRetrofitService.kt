package com.rodrigomadeiro.bootstrap.data.retrofit

import retrofit2.http.GET
import retrofit2.http.Path

interface MockyIoMtgRetrofitService {

    @GET("/27281321-1b5c-4bd4-bcef-6ee80a3c73df")
    fun list(): List<MockyIoMtgColorListItem>

    @GET("/{id}")
    fun get(@Path("id") id:String ): MockyIoMtgColorDetailItem
}