package com.example.retrofit_ii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    private lateinit var responseList: ResponseDTO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnEnter.setOnClickListener {

            callApi()
        }
    }

    private fun callApi() {
        val apiretrofit = Network.getRetrofitInstance().create(ApiRetrofit::class.java)
        apiretrofit.getPosts(etPostid.text.toString().toInt())
            .enqueue(object : retrofit2.Callback<ResponseDTO> {
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    responseList = response.body()!!
                    setRecyclerView()
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {

                }
            })
    }

    private fun setRecyclerView() {
        val adaptor = Adaptor(responseList)
        val linearLayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = linearLayoutManager
        recyclerView.adapter = adaptor
    }
}