package com.example.kotlinscopingfunctionsyou

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class ClientHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun setData(data: Data){

        view.apply {
            TvName.text = data.firstName
            TvEmail.text = data.email
            TvId.text = data.id.toString()
            Glide.with(IvImage).load(data.avatar).into(IvImage)
        }
    }
}