package com.example.musicplayer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        val bundle : Bundle?=intent.extras
        tvTrackName.text = bundle!!.getString("TrackName")
        tvArtistName.text = bundle!!.getString("ArtistName")
        tvCollectionName.text = bundle!!.getString("CollectionName")
        val imageid = bundle!!.getInt("Image")
        ivImageView.setImageResource(bundle!!.getInt("Image"))
        
    }
}