package com.example.livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val dataClass = DataClass()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiBtn.setOnClickListener {
            dataClass.getAPINewData()
        }

        dbBtn.setOnClickListener {
            dataClass.getDBNewData()
        }
        // returning the live data
//        dataClass.getAPINewData().observe(this, Observer {
//            val data = it
//            textView.text = data
//        })
//
//        dataClass.getDBNewData().observe(this, Observer {
//            val data = it
//            textView.text = data
//        })

        dataClass.getMeditatorLiveData().observe(this, Observer {
            textView.text = it
        })
    }
}