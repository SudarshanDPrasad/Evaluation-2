package com.example.musicplayer

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_layout.view.*

class MusicHolder(private val view: View,listener: OnItemClickListener) : RecyclerView.ViewHolder(view) {

    fun setData(resultdto: Resultdto) {
        view.apply {
            tvTrackName.text = resultdto.trackName
            Glide.with(ivImageView).load(resultdto.artworkUrl100).into(ivImageView)
            tvArtistName.text = resultdto.artistName
            tvCollectionName.text = resultdto.collectionName

        }
    }
    init {
        view.setOnClickListener{
            listener.onItemClick(adapterPosition)
        }
    }
}
