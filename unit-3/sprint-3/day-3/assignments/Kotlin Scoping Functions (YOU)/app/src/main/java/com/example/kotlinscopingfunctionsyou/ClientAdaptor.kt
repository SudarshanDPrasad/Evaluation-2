package com.example.kotlinscopingfunctionsyou

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class ClientAdaptor(private val responseDTO: List<ResponseDTO>) : RecyclerView.Adapter<ClientHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ClientHolder(view)
    }

    override fun onBindViewHolder(holder: ClientHolder, position: Int) {
        val model: Data = responseDTO[position].data[position]
        holder.setData(model)


    }

    override fun getItemCount(): Int {
        return responseDTO.size
    }
}