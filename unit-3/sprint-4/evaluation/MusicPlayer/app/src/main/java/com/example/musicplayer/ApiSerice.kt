package com.example.musicplayer

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiSerice {
    @GET("search")
    fun getResults(@Query("term") term: String) :  Call<ReponseDto>

}