package com.example.kotlinscopingfunctionsyou

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_client.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ClientFragment : Fragment(R.layout.fragment_client) {


    private lateinit var responseDTO: List<ResponseDTO>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApi()

    }

    private fun callApi() {

        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getposts(5)
            .enqueue(object : Callback<List<ResponseDTO>> {
                override fun onResponse(
                    call: Call<List<ResponseDTO>>,
                    response: Response<List<ResponseDTO>>
                ) {

                    response.body()?.run {
                        responseDTO = this
                        setRecyclerView()
                    }
                }

                override fun onFailure(call: Call<List<ResponseDTO>>, t: Throwable) {

                }

            })
    }

    private fun setRecyclerView() {
        val adaptor = ClientAdaptor(responseDTO)
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerview.layoutManager = linearLayoutManager
        recyclerview.adapter = adaptor
    }
}