package com.example.eventskotlin

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_events_deatils.*


class EventsDeatilsFragment : Fragment(R.layout.fragment_events_deatils) {


    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnnext.setOnClickListener {
            val Title = etEventTitle.text.toString()
            val Description = etEventDescription.text.toString()
            val bundle = Bundle()
            bundle.putString("Tittle", Title)
            bundle.putString("Description", Description)
            navController.navigate(
                R.id.action_eventsDeatilsFragment2_to_timeandDateFragment2,
                bundle
            )
        }
    }
}