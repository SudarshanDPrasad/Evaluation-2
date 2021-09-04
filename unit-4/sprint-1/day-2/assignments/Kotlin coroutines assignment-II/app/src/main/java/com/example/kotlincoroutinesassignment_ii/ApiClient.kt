package com.example.kotlincoroutinesassignment_ii

import retrofit2.Call
import retrofit2.http.GET

interface ApiClient {
    @GET("v3/0404dd7e-c1ba-4669-b14b-3331f46741ec")
    fun getInidanToons(): Call<ResponseModel>
}