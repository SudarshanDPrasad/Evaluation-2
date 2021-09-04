package com.example.kotlincoroutinesassignment_ii


import com.google.gson.annotations.SerializedName

data class ResponseModel(
    @SerializedName("Indian Toons")
    val indianToons: List<IndianToon>
)