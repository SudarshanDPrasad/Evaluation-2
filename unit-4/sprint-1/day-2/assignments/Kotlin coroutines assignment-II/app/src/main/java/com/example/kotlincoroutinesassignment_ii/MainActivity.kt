package com.example.kotlincoroutinesassignment_ii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var indianToon: List<IndianToon>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        CoroutineScope(Dispatchers.IO).launch {

            val res1: String = async {

                delay(3000)
               // val data: String = getDataFromApi()
                val apiClient = Network.getInstance().create(ApiClient::class.java)
                apiClient.getInidanToons().enqueue(
                    object : Callback<ResponseModel> {
                        override fun onResponse(
                            call: Call<ResponseModel>,
                            response: Response<ResponseModel>,
                        ) {

                            response.body()?.run {
//                                indianToon = response.body()!!
                               tvMovieName.text =  response.body()?.indianToons?.get(3)?.movieName.toString()
                                Log.d("sudarshan", response.body()?.indianToons?.get(0).toString()+" ")
                            }
                        }

                        override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        }

                    }
                )


                return@async "apiClient"
            }.await()

            val res2: String = async {

                val data1: String = getDataFromApi()
                val apiClient1 = Network.getInstance().create(ApiClient::class.java)
                apiClient1.getInidanToons().enqueue(
                    object : Callback<ResponseModel> {
                        override fun onResponse(
                            call: Call<ResponseModel>,
                            response: Response<ResponseModel>,
                        ) {

                            response.body()?.run {
                                tvDirectorName.text = response.body()?.indianToons?.get(3)?.director?.toString()
                            }
                        }

                        override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        }

                    }
                )
                return@async "apiClient1"
            }.await()

            val res3: String = async {

                val data2: String = getDataFromApi()
                val apiClient3 = Network.getInstance().create(ApiClient::class.java)
                apiClient3.getInidanToons().enqueue(
                    object : Callback<ResponseModel> {
                        override fun onResponse(
                            call: Call<ResponseModel>,
                            response: Response<ResponseModel>,
                        ) {

                            response.body()?.run {
                                tvLanguage.text = response.body()?.indianToons?.get(3)?.language?.toString()
                            }
                        }

                        override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                        }

                    }
                )
                return@async "apiClient3"
            }.await()

            CoroutineScope(Dispatchers.Main).launch {
                tvDirectorName.text = res2
                tvMovieName.text = res1
                tvLanguage.text = res3
            }
        }
    }

    suspend fun getDataFromApi(): String {
        delay(3000)
        return "api response recieved"

    }
    
}