package com.boss.myrubelapp.materi.greeting

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_apology.*

class ApologyActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "AN7PLezq4O0"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_apology)

        youtubePlayerInit = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubePlayer?,
                    p2: Boolean) {
                p1?.loadVideo(VIDEO_ID)
            }

            override fun onInitializationFailure(
                    p0: YouTubePlayer.Provider?,
                    p1: YouTubeInitializationResult?
            ) {
                Toast.makeText(applicationContext, "Failed", Toast.LENGTH_SHORT).show()
            }
        }
        btnPlay.setOnClickListener{
            youTubePlayerView.initialize(R.string.YOUTUBE_API.toString(), youtubePlayerInit)
        }

        showApology()
    }

    @SuppressLint("SetTextI18n")
    fun showApology() {
        tvApology.text = "Sorry (maaf)\nI'm so sorry (aku sangat minta maaf)\nPlease forgive me (mohon maafkan saya)\nIt's all my fault (ini semua salahku)\nSorry for losing your book (maafkan aku menghilangkan buku mu)"
        tvResponse2.text = "Never mind (jangan dipikirkan)\nIt's ok! (tidak apa apa)\nNo problem (tidak masalah)\nForget it (lupakan saja)\nDon't worry about it (jangan khawatir)\nIt doesn't matter (itu tidak masalah)"
    }

}