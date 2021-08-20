package com.example.postrequest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_recieve.*


class RecieveActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recieve)
        val intent = intent

        if (intent != null) {
            tvEmail.setText(intent.getStringExtra("email"))
            tvPassword.setText(intent.getStringExtra("password"))
            tvTitle.setText(intent.getStringExtra("title"))
            tvRequestType.setText(intent.getStringExtra("requestType"))
        }
    }

}