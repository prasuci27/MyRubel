package com.boss.myrubelapp.materi.world

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_demonstrative.*

class DemonstrativeActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "BZ95Fv7cIb4"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demonstrative)

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

        showDemo()
    }

    @SuppressLint("SetTextI18n")
    fun showDemo() {
        tvDemonstrative.text = "Demonstrative determiner (this, that, these, those) berfungsi untuk menunjukkan jumlah di mana objek (kata benda) yang sedang dibicarakan berada, terkait dengan seberapa jauh objek tersebut dari pembicaranya. Kalau di bahasa indonesia kita kenal dengan ini dan itu.\n" +
                "\n" +
                "This dan These memiliki arti “ini”. Bedanya adalah This untuk benda tunggal (singular) dan these untuk benda jamak (plural). Contohnya yaitu This is a book yang artinya Ini adalah sebuah buku (jumlahnya satu). These are books yang artinya Ini adalah buku (jumlahnya lebih dari satu).\n" +
                "\n" +
                "Sedangkan That dan Those memiliki arti “itu”. Bedanya adalah That untuk benda tunggal (singular) dan Those untuk benda jamak (plural). Contohnya yaitu That is a book yang artinya Itu adalah sebuah buku (jumlahnya satu). Those are books yang artinya Itu adalah buku (jumlahnya lebih dari satu)."

        tvFunction_Demo.text = "1. This digunakan untuk kata benda tunggal yang berada dekat dengan pembicara\n" +
                "- This is a book\n" +
                "- This is not an apple\n" +
                "- Is this a magnifier ?\n\n" +
                "2. That digunakan untuk kata benda tunggal yang berada jauh dari pembicara.\n" +
                "- That is an apple\n" +
                "- That is not a scissor\n" +
                "- Is this a paperclip?\n\n" +
                "3 These digunakan untuk objek banyak yang berada dekat dengan pembicara.\n" +
                "- These are photos of our trip\n" +
                "- These are not apples\n" +
                "- Are these sentences correct?\n\n" +
                "4. Those digunakan untuk objek banyak yang berada jauh dari pembicara.\n" +
                "- Those are a few of my favorite books\n" +
                "- Those are not my monkeys\n" +
                "- Are those plates of fetuccine or plates of carbonara?"
    }
}