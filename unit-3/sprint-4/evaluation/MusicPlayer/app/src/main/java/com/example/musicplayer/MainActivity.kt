package com.example.musicplayer

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(), OnItemClickListener {

    private lateinit var listofmusic: List<Resultdto>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btntosearch.setOnClickListener {
            apiCall()
        }
    }

    private fun apiCall() {
        var apiclient = Network.getRetrofitInstance().create(ApiSerice::class.java)
        apiclient.getResults(etToSearch.text.toString()).enqueue(object : Callback<ReponseDto> {
            override fun onResponse(call: Call<ReponseDto>, response: Response<ReponseDto>) {

                response.body()?.run {
                    listofmusic = results
                    setRecyclerView()
                }
            }

            override fun onFailure(call: Call<ReponseDto>, t: Throwable) {
                Toast.makeText(this@MainActivity, t.message, Toast.LENGTH_LONG).show()
            }

        })
    }

    private fun setRecyclerView() {

        val adaptor = Musicadaptor(listofmusic)
        val linearLayoutManager = LinearLayoutManager(this)
        rcRecyclerView.adapter = adaptor
        rcRecyclerView.layoutManager = linearLayoutManager
    }

    override fun onItemClick(item: Resultdto, position: Int) {
        val intent = Intent(this@MainActivity,PlayActivity::class.java)
        startActivity(intent)
    }
}