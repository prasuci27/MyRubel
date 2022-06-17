package com.boss.myrubelapp.materi.intro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_introduction.*

class IntroductionActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "cGZfv0gBRrc"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_introduction)

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

        showIntro()
    }
     @SuppressLint("SetTextI18n")
     fun showIntro() {
         tvPreposition.text = "My name is (nama ku ...)\nMy full name is ...(nama lengkap ku ...)\nMy nick name is ...(nama panggilan saya...)\nLet me introduce my self. My name is ...(izinkan aku memperkenalkan diri. nama ku ...)"
         tvIntro2.text = "This is a friend of mine, Andika. (Ini teman saya, Andika)\nChika, this is Andika, my friend. (Chika, ini Andika, teman saya)\nMay I introduce my friend? (Bolehkan saya memperkenalkan teman saya?)"
     }


}