package com.example.navigationgraphiw

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_student_performance_detail.*


class StudentPerformanceDetailFragment : Fragment(R.layout.fragment_student_performance_detail) {

    private lateinit var name: String
    private var age: Int = 0
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getDataBundle()

    }

    private fun getDataBundle() {
        arguments?.run {
            name = getString("name")!!
            age = getInt("age")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        btnPreview.setOnClickListener {
            val grade = etStudentGrade.text.toString()
            val percentage = etStudentPercentage.text.toString()
            val intent = Intent(context, PreviewActivity::class.java)
            intent.putExtra("name",name)
            intent.putExtra("age",age)
            intent.putExtra("Grade",grade)
            intent.putExtra("Percentage",percentage)
            startActivity(intent)
        }
    }
}