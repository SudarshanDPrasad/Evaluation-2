package com.example.contentprovidersassignment

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.SimpleCursorAdapter
import com.example.contentprovidersassignment.adaptor.showAdaptor
import com.example.contentprovidersassignment.model.MessageModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.row.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var adaptor: SimpleCursorAdapter
    private var Sms : MutableList<MessageModel> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnInbox.setOnClickListener(this)
        btnSentBox.setOnClickListener(this)
    }

    override fun onClick(item: View?) {
        if(item == btnInbox){
            val inbox = Uri.parse("content://sms/inbox")
            val requiredColumn = arrayOf("_id", "address", "body")
            val cursor = contentResolver
            val c = cursor.query(inbox, requiredColumn, null, null, null)

            adaptor = SimpleCursorAdapter(
                this, R.layout.row, c, arrayOf("body", "address"), intArrayOf(
                    R.id.Name, R.id.Number)
            )
            listview.adapter = adaptor
        }

        if(item == btnSentBox){
            val inbox = Uri.parse("content://sms/sent")
            val requiredColumn = arrayOf("_id", "address", "body")
            val cursor = contentResolver
            val c = cursor.query(inbox, requiredColumn, null, null, null)

            adaptor = SimpleCursorAdapter(
                this, R.layout.row, c, arrayOf("body", "address"), intArrayOf(
                    R.id.Name, R.id.Number)
            )
            listview.adapter = adaptor
        }

    }
}