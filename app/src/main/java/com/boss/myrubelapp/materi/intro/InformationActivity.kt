package com.boss.myrubelapp.materi.intro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "qDn3yJHRnUQ"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

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
            showInfo()
    }

    @SuppressLint("SetTextI18n")
    fun showInfo() {
        tvRules.text = "Memulai kalimat tanya dengan 5W+1H. Seperti What (apa), Where (dimana), Why (kenapa), When (kapan), Who (siapa), dan How (bagaimana)"
        tvAskingExample.text = "What is your name ? (Siapa nama mu ?)\n Where are you from? (Dari mana asal mu?)\n Where do you live? (Dimana kamu tiggal?\n How old are you? (berapa umur mu?)\n What is your hobby? (Apa hobi mu?)\n Where do you study? (Dimana kamu bersekolah?)\n"
        tvGiving.text = "My name is Cici (nama saya Cici)\n I'm from Batusangkar (Aku berasal dari Batusangkar)\n I live in Pariangan street number 10 (Saya tinggal di jalan pariangan nomor 10)\n I'm 13 years old (Aku berumur 13 tahun)\n My hobby is reading (Hobi saya adalah membaca)\n I'm a student of MTs Tabek on seven grade (Saya murid MTs Tabek kelas tujuh)"

    }
}