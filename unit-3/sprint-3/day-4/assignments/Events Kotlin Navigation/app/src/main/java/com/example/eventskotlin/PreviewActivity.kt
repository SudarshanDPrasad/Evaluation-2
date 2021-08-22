package com.example.eventskotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_preview.*

class PreviewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview)
        getDataFromIntent()
    }

    private fun getDataFromIntent() {
        intent?.run {
            tvtittle.text = getStringExtra("Tittle")
            tvdescription.text = getStringExtra("Description")
            tvstartdate.text = getStringExtra("StartDate")
            tvenddate.text = getStringExtra("EndDate")
            tvstarttime.text = getStringExtra("StartTime")
            tvendtime.text = getStringExtra("EndTime")
            tvcurrency.text = getStringExtra("Currency")
            tvPrice.text = getStringExtra("Price")
        }
    }
}