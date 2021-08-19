package com.example.loadtenanimalsprofileinafragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var FragmentManager: FragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Buttontolauch.setOnClickListener {
            launchFragment()
            Buttontolauch.visibility = View.GONE
        }
    }

    private fun launchFragment() {
        var fragmentManager = supportFragmentManager
        val animalFragment = AnimalFragment()
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.change, animalFragment).commit()

    }
}

