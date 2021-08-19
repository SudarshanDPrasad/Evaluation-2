package com.example.getuserdetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var responseList: Response;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnEnter.setOnClickListener {
            callApi()
        }

    }

    private fun callApi() {

        val apiservice = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiservice.getSource(etNumber.text.toString().toInt())
            .enqueue(object : Callback<Response>{
                override fun onResponse(call: Call<Response>, response: retrofit2.Response<Response>) {

                    responseList = response.body()!!
                    TvEmail.text = responseList.data!!.email
                    TvCompany.text = responseList.data!!.lastName
                    Toast.makeText(this@MainActivity," Thank you for using the service ",Toast.LENGTH_SHORT).show()
                }

                override fun onFailure(call: Call<Response>, t: Throwable) {
                }

            })
    }
}