package com.example.moneymanager

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_layout_row.*

class MainActivity : AppCompatActivity(), OnitemClickListener {
    lateinit var moneyMangerAdaptor: MoneyMangerAdaptor
    private val tasksList = mutableListOf<Money>()

    private val dbhandler = database(this)

    var amountincome = 0.0
    var amountexpenses = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnadd.setOnClickListener {
            val intent = Intent(this, AddActivity::class.java)
            startActivity(intent)

            updateUi()
        }




        moneyMangerAdaptor = MoneyMangerAdaptor(this, tasksList, this)
        recyclerview.layoutManager = LinearLayoutManager(this)
        recyclerview.adapter = moneyMangerAdaptor
        Income()
        Expenses()

         amountincome = dbhandler.getIncomeExpneses()
         amountexpenses = dbhandler.getExpenseExpneses()
        if (amountincome != null && amountexpenses != null) {
            tvBalanceMoney.text = (amountincome - amountexpenses).toString()
        }


    }


    fun Income() {

        tvIncomeMoney.text = dbhandler?.getIncomeExpneses().toString()
        updateUi()

    }

    fun Expenses() {

        tvExpensesMoney.text = dbhandler?.getExpenseExpneses().toString()
        updateUi()
    }

    override fun OnEdit(money: Money) {

        val intent = Intent(this, AddActivity::class.java)
        startActivity(intent)

        var titleupdate = intent.getStringExtra("updatetitle")
        var amountupdate = intent.getStringExtra("updateamount")

        if (titleupdate != null) {
            money.mTvDescription = titleupdate
        }

        money.mTvDescription = tvIncomeDesc.toString()


        dbhandler.editTask(money)

        updateUi()
    }


    override fun onDelete(money: Money) {

        dbhandler.deleteTask(money)
        updateUi()
    }

    @SuppressLint("NotifyDataSetChanged")
    fun updateUi() {
        val latestTask = dbhandler.getAllTasks()
        tasksList.clear() //if we won't do this then it will create a duplicate values
        tasksList.addAll(latestTask)
        moneyMangerAdaptor.notifyDataSetChanged()
    }
}



