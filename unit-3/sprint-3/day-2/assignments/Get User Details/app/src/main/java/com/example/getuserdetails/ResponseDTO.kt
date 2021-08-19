package com.example.getuserdetails

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Response(

    @field:SerializedName("data")
    val data: Data? = null,

    @field:SerializedName("support")
    val support: Support? = null
)