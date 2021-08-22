package com.example.eventskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_timeand_date.*


class TimeandDateFragment : Fragment(R.layout.fragment_timeand_date) {

    private lateinit var Title: String
    private lateinit var Description: String
    private lateinit var navController: NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBundle()
    }

    private fun getDataBundle() {
        arguments?.run {
            Title = getString("Tittle")!!
            Description = getString("Description")!!
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btntoprice.setOnClickListener {
            val startDate = etStartDate.text.toString()
            val endDate = etEndDate.text.toString()
            val startTime = etStartTime.text.toString()
            val endTime = etEndTime.text.toString()
            val bundle = Bundle()
            bundle.putString("Tittle", Title)
            bundle.putString("Description", Description)
            bundle.putString("startDate", startDate)
            bundle.putString("endDate", endDate)
            bundle.putString("startTime", startTime)
            bundle.putString("endTime", endTime)
            navController.navigate(
                R.id.action_timeandDateFragment2_to_priceDetailsFragment2,
                bundle
            )
        }
    }

}