package com.example.retrofit_ii

import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface ApiRetrofit {

    @GET("comments")
    fun getPosts(@Query("postId") postId : Int): Call<ResponseDTO>
}