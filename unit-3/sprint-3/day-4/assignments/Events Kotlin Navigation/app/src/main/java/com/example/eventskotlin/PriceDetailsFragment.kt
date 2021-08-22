package com.example.eventskotlin

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import kotlinx.android.synthetic.main.fragment_price_details.*
import java.util.*


class PriceDetailsFragment : Fragment(R.layout.fragment_price_details) {


    private lateinit var Title: String
    private lateinit var Description: String
    private lateinit var StartDate: String
    private lateinit var EndDate: String
    private lateinit var StartTime: String
    private lateinit var EndTime: String
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getBundleData()
    }

    private fun getBundleData() {
        arguments?.run {
            Title = getString("Tittle")!!
            Description = getString("Description")!!
            StartDate = getString("startDate")!!
            EndDate = getString("endDate")!!
            StartTime = getString("startTime")!!
            EndTime = getString("endTime")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btntoPreview.setOnClickListener {
            val Currency = etCurrency.text.toString()
            val Price = etPrice.text.toString()
            val intent = Intent(activity, PreviewActivity::class.java)
            intent.putExtra("Tittle", Title)
            intent.putExtra("Description", Description)
            intent.putExtra("StartDate", StartDate)
            intent.putExtra("EndDate", EndDate)
            intent.putExtra("StartTime", StartTime)
            intent.putExtra("EndTime", EndTime)
            intent.putExtra("Currency", Currency)
            intent.putExtra("Price", Price)
            startActivity(intent)
        }
    }
}