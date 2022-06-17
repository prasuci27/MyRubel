package com.boss.myrubelapp.materi.days

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_preposition.*

class PrepositionActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "F_Qyc6LiEA0"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preposition)

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

        showPreposition()

    }

    @SuppressLint("SetTextI18n")
    fun showPreposition() {
        tvPreposition.text = "Preposition of time adalah kata depan yang digunakan untuk menunjukkan waktu.\n" +
                "At untuk waktu yang sudah pasti/tepat.\n" +
                "On untuk hari (days), tanggal (dates)\n" +
                "In untuk bulan (months), tahun (years), abad (centuries), jangka waktu yang panjang (long periods), musim (seasons)."

        tvPrepoExample.text = "- I have a class at 1 P.M (Aku ada kelas pad ajam 1 siang)\n" +
                "- In Korea, it often snows in December (Di Korea, biasanya musim salju pada bulan Desember)\n" +
                "- His birthday is on 21st January (Ulang tahunnya pada tanggal 21 Januari"
    }
}