package com.example.musicplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class Musicadaptor(val responseDto: List<Resultdto>,private val listener: OnItemClickListener) : RecyclerView.Adapter<MusicHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
       return MusicHolder(view,listener)

    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        val model : Resultdto = responseDto[position]
        holder.setData(model)
    }

    override fun getItemCount(): Int {
        return responseDto.size
    }

}
