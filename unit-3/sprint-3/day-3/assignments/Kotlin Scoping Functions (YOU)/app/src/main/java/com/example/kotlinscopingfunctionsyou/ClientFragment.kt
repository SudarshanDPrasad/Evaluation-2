package com.example.kotlinscopingfunctionsyou

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_client.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClientFragment : Fragment(R.layout.fragment_client) {


    private lateinit var responseDTO: List<Data>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApi()

    }

    private fun callApi() {

        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        val call = apiClient.getposts(2)
           call.enqueue(object : Callback<ResponseDTO>{
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {

                    response.body()?.run {
                        responseDTO = data
                        setRecyclerView()
                    }
                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    Toast.makeText(context,"error",Toast.LENGTH_LONG).show()
                }

            })
    }

    private fun setRecyclerView() {
        val adaptor = ClientAdaptor(responseDTO)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerview.adapter = adaptor
        recyclerview.layoutManager = linearLayoutManager
    }
}

//bro i cannnot able to handle your pc properly