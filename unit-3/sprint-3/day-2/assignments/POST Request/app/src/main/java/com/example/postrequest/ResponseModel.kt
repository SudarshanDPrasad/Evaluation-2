package com.example.postrequest

import com.google.gson.annotations.SerializedName




class ResponseModel {

    @SerializedName("email")
    private var email: String? = null

    @SerializedName("password")
    private var password: String? = null

    @SerializedName("title")
    private var title: String? = null

    @SerializedName("requestType")
    private var requestType: String? = null

    fun setEmail(email: String?) {
        this.email = email
    }

    fun getEmail(): String? {
        return email
    }

    fun setPassword(password: String?) {
        this.password = password
    }

    fun getPassword(): String? {
        return password
    }

    fun setTitle(title: String?) {
        this.title = title
    }

    fun getTitle(): String? {
        return title
    }

    fun setRequestType(requestType: String?) {
        this.requestType = requestType
    }

    fun getRequestType(): String? {
        return requestType
    }
}