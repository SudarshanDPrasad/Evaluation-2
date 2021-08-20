package com.example.kotlinscopingfunctions

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_user_details.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserDetailsFragment : Fragment(R.layout.fragment_user_details) {

    private lateinit var responseDTO: ResponseDTO


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ButtontoCall.setOnClickListener {
            callApi()
        }
    }

    private fun callApi() {
        val apiClient = Network.getRetrofitInstance().create(ApiClient::class.java)
        apiClient.getSource(2)
            .enqueue(object : Callback<ResponseDTO> {
                override fun onResponse(call: Call<ResponseDTO>, response: Response<ResponseDTO>) {
                    //this is option to run the program or to take the details from API

                    response.body()?.run {
                        responseDTO = this

                        responseDTO.data?.apply {
                            TvName.text = firstName
                            TvLastName.text = lastName
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseDTO>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
}