package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.fragment_item.*

class MainActivity : AppCompatActivity() {

    private val dataBaseHandler = DataBaseHandler(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btntoSave.setOnClickListener{
            dataBaseHandler?.inserTask(etAddItem.text.toString(),eDescItem.text.toString(),etPriceItem.text.toString().toInt())
        }

    }
}