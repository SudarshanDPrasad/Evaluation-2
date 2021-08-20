package com.example.postrequest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private var  responseModel = ResponseModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnPostRequest.setOnClickListener {
            sendData();
        }
    }

    private fun sendData() {
        val email = etEmail.text.toString()
        responseModel.setEmail(email)
        val password = etPassword.text.toString()
        responseModel.setPassword(password)
        val title = etTitle.text.toString()
        responseModel.setTitle(title)
        val requestType = etRequestType.text.toString()
        responseModel.setRequestType(requestType)

        val apiService = Network.getRetrofitInstance().create(
            ApiService::class.java
        )
        val call: Call<ResponseModel?>? = apiService.sendData(responseModel)
        if (call != null) {
            call.enqueue(object : Callback<ResponseModel?> {
                override fun onResponse(call: Call<ResponseModel?>?, response: Response<ResponseModel?>?) {
                    val responseModel: ResponseModel? = response?.body()
                    if (response != null) {
                        val intent = Intent(this@MainActivity, RecieveActivity::class.java)
                        intent.putExtra("email", responseModel?.getEmail())
                        intent.putExtra("password", responseModel?.getPassword())
                        intent.putExtra("title", responseModel?.getTitle())
                        intent.putExtra("requestType", responseModel?.getRequestType())
                        startActivity(intent)
                    }
                }

                override fun onFailure(call: Call<ResponseModel?>?, t: Throwable?) {}
            })
        }
    }
}