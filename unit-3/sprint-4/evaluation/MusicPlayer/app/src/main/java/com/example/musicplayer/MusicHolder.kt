package com.example.musicplayer

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicHolder(private val view : View) : RecyclerView.ViewHolder(view)  {

    fun setData(resultdto: Resultdto){
        view.apply {
            tvTrackName.text = resultdto.artistName;

        }
    }
}