package com.example.kotlinscopingfunctionsyou

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiClient {

    @GET("users")
    fun getposts(@Query("page") page : Int)  : Call<List<ResponseDTO>>
}