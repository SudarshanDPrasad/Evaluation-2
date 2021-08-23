package com.example.musicplayer

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat


class MusicService() : Service() {


    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this,R.raw.songs)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        startMusic()
        return super.onStartCommand(intent, flags, startId)
    }



    private fun startMusic() {
        val thread = Thread(task)
        thread.start()
    }

    private val task = Runnable {
        mediaPlayer!!.start()
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")
    }

    fun play() {
        if (!mediaPlayer!!.isPlaying) mediaPlayer!!.start()
    }

    fun pause() {
        if (mediaPlayer!!.isPlaying) mediaPlayer!!.pause()
    }

}