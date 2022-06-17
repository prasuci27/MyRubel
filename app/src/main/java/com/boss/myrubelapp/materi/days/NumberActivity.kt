package com.boss.myrubelapp.materi.days

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_menyapa.btnPlay
import kotlinx.android.synthetic.main.activity_menyapa.youTubePlayerView
import kotlinx.android.synthetic.main.activity_number.*

class NumberActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "3guFzSR6zEw"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)

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

        showOrdinal()
    }

    @SuppressLint("SetTextI18n")
    fun showOrdinal() {
        tvOrdinal.text = "Ordinal number adalah angka yang digunakan untuk menyatakan suatu urutan atau tahapan. Contoh First= pertama, second=kedua, third=ketiga, dst"
        tvOrdinalExample.text = "- Santi is the first child in her family. (Santi adalah anak pertama di keluarganya)\n" +
                "- My office is on the fifth floor. (Kantorku berada di lantai kelima)\n" +
                "- I was born on October twenty second, nineteenth eighty eight. (Aku lahir pada tanggal 22 Oktober 1988)\n" +
                "- Soni got the second winner of the English debate competition. (Soni mendapatkan peringkat kedua pada kompetisi debat bahasa Inggris)"
    }
}