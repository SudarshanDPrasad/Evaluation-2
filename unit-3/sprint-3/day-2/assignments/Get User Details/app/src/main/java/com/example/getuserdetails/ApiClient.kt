package com.example.getuserdetails

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiClient {

    @GET("api/users/{Value}")
    fun getSource(@Path("Value") Value: Int): Call<Response>
}