package com.example.musicpreview.holderandadaptor

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.musicpreview.ApiService.ResponseDTO
import com.example.musicpreview.R

class Adaptor(private val responseDTO: List<ResponseDTO>) : RecyclerView.Adapter<Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
   val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false);
        return Holder(view);
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

    }

    override fun getItemCount(): Int {
     return responseDTO.size;
    }
}