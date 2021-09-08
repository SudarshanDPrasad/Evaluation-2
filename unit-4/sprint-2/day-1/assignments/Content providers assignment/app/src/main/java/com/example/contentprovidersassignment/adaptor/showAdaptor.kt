package com.example.contentprovidersassignment.adaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.contentprovidersassignment.R
import com.example.contentprovidersassignment.holder.showViewholder
import com.example.contentprovidersassignment.model.MessageModel

class showAdaptor (var messageModel: List<MessageModel>) : RecyclerView.Adapter<showViewholder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): showViewholder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return showViewholder(view)
    }

    override fun onBindViewHolder(holder: showViewholder, position: Int) {
        val messageModel : MessageModel = messageModel[position]
        holder.setData(messageModel)
    }

    override fun getItemCount(): Int {
        return messageModel.size
    }
}