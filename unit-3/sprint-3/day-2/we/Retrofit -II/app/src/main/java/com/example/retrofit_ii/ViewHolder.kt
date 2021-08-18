package com.example.retrofit_ii

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class ViewHolder(private val view : View ) : RecyclerView.ViewHolder(view) {

    fun setData(responseItem: ResponseDTOItem){


        view.apply {
            TvDisplay.text = responseItem.name
            TvBody.text = responseItem.body
            TvEmail.text = responseItem.email
        }
    }
}