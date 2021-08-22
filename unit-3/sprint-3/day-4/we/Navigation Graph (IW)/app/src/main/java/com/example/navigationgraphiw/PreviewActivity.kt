package com.example.navigationgraphiw

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
            tvStudentName.text = getStringExtra("name")
            tvStudentAge.text = "${getIntExtra("age",0)}"
            tvStudentGrade.text = getStringExtra("Grade")
            tvStudentPercentage.text = getStringExtra("Percentage")
        }
    }

}