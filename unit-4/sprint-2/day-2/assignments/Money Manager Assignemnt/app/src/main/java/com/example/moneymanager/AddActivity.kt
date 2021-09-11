package com.example.moneymanager

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_add.*

class AddActivity : AppCompatActivity() {

    private val dbhandler = database(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        btnincome.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            dbhandler?.insertTask(tvIncomeDesc.text.toString(),tvAmountincome.text.toString().toDouble(),"Income")
            startActivity(intent)
        }

        btnExpenses.setOnClickListener {

            val intent = Intent(this,MainActivity::class.java)
            dbhandler?.insertTask(tvExpensesDesc.text.toString(),tvExpenseAmount.text.toString().toDouble(),"Expenses")
            startActivity(intent)
        }

        btnUpdate.setOnClickListener{
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}