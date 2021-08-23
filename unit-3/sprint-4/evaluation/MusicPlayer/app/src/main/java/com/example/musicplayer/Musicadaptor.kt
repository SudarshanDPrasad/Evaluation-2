package com.example.musicplayer

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Response

class Musicadaptor(val responseDto: List<ReponseDto>) : RecyclerView.Adapter<MusicHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MusicHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
       return MusicHolder(view)

    }

    override fun onBindViewHolder(holder: MusicHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}