package com.example.musicpreview.ApiService


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Result>
)