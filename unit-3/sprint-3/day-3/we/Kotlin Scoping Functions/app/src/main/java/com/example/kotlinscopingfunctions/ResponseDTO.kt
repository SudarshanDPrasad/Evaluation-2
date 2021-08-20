package com.example.kotlinscopingfunctions


import com.google.gson.annotations.SerializedName

data class ResponseDTO(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("support")
    val support: Support
)