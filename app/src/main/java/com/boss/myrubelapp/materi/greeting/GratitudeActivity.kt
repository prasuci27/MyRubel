package com.boss.myrubelapp.materi.greeting

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_gratitude.*

class GratitudeActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "yg8OI4-DW28"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gratitude)

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

        showGratitude()
    }

    @SuppressLint("SetTextI18n")
    fun showGratitude() {
        tvGratitude.text = "Thank you/Thanks (terima kasih)\nThank you very much (terima kasih banyak)\nThanks a lot (terima kasih banyak)\nIt means a lot for me (ini sangat berharga banyak untukku)\nI really appreciate your kindness (aku sangat menghargai kebakanmu)"
        tvResponse1.text = "My Pleasure (Dengan senang hati)\nYou're welcome (sama-sama)\nNo problem (tidak apa apa)\nI'm glad that I can help you (aku senang bisa membantumu)\nDon't mention it (tidak masalah)"

    }
}