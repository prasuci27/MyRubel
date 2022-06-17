package com.boss.myrubelapp.materi.intro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_pronoun.*

class PronounActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "5nH1qkyoFd4"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pronoun)

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

        tvPronounExample.text = "Kata ganti yang berfungsi sebagai subjek dalam sebuah kalimat.\n" +
                "\n" +
                "- I will go to Bandung tomorrow. (Aku akan pergi ke Bandung besok)\n" +
                "\n" +
                "- You are my cousin. (Kamu adalah sepupuku)"
    }


}