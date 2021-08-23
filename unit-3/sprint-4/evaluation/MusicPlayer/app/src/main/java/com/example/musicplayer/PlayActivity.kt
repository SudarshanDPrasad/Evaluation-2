package com.example.musicplayer

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_play.*

class PlayActivity : AppCompatActivity() {

    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        mediaPlayer = MediaPlayer.create(this, R.raw.songs)

        val bundle: Bundle? = intent.extras
        tvTrackName.text = bundle!!.getString("TrackName")
        tvArtistName.text = bundle!!.getString("ArtistName")
        tvCollectionName.text = bundle!!.getString("CollectionName")
        val imageid = bundle!!.getInt("Image")
        ivImageView.setImageResource(bundle!!.getInt("Image"))


    }


}