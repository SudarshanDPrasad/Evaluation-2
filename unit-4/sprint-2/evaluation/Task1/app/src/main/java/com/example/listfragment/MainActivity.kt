package com.example.listfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_item.*
import kotlinx.android.synthetic.main.fragment_search.*

class MainActivity : AppCompatActivity() {

    private lateinit var adaptor: ItemAdaptor
    private val addModel = listOf<AddModel>()
    private var tasksList = mutableListOf<AddModel>()
    private val dataBaseHandler = DataBaseHandler(this)
    private val liveData = LiveData()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btntoSave.setOnClickListener {
            dataBaseHandler?.inserTask(etAddItem.text.toString(),
                eDescItem.text.toString(),
                etPriceItem.text.toString().toInt())

        }

        btntoSearch.setOnClickListener {
            tasksList.clear()
            tasksList.addAll(dataBaseHandler.getSearchTask(ettoSearch.text.toString()))
            liveData.getData(tasksList.size)
            adaptor.notifyDataSetChanged()

        }


        liveData.getcountData().observe(this, Observer {
            tvCount.text = it
        })
        val LayoutManager = LinearLayoutManager(this)
        adaptor = ItemAdaptor(addModel, tasksList)
        RecyclerViewSearch.adapter = adaptor
        RecyclerViewSearch.layoutManager = LayoutManager


    }
}