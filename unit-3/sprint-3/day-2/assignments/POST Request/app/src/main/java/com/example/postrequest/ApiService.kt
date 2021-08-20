package com.example.postrequest

import retrofit2.Call
import retrofit2.http.Body

import retrofit2.http.POST




interface ApiService {

    @POST("/posts")
    fun sendData(@Body data: ResponseModel?): Call<ResponseModel?>?
}