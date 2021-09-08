package com.example.contentprovidersassignment.holder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovidersassignment.model.MessageModel
import kotlinx.android.synthetic.main.item_layout.view.*

class showViewholder(var view : View) : RecyclerView.ViewHolder(view){

    fun setData(messageModel: MessageModel){
        itemView.apply {
            tvName.text = messageModel.Name
            tvMessage.text = messageModel.Message
        }
    }
}