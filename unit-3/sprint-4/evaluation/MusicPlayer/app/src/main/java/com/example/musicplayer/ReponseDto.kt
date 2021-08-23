package com.example.musicplayer


import com.google.gson.annotations.SerializedName

data class ReponseDto(
    @SerializedName("resultCount")
    val resultCount: Int,
    @SerializedName("results")
    val results: List<Resultdto>
)