package com.example.getuserdetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Support(

    @field:SerializedName("url")
    val url: String? = null,

    @field:SerializedName("text")
    val text: String? = null
)