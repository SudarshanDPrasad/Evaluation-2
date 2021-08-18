package com.example.retrofit_ii

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adaptor(val responseDTO: ResponseDTO )  : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val model : ResponseDTOItem = responseDTO[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
       return responseDTO.size;
    }
}