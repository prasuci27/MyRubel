package com.boss.myrubelapp.materi.intro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_present.*

class PresentActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "E1q56pZNswE"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_present)

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

        showSimple()
    }

    @SuppressLint("SetTextI18n")
    fun showSimple() {
        tvPreposition.text = "Simple Present adalah tenses (pola kalimat) yang digunakan untuk menceritakan waktu sekarang dalam bentuk sederhana."
        tvFunction.text = "1. Untuk menceritakan suatu aktifitas yang dilakukan berulang-ulang (repeatedly), atau kebiasaan (habitually). Kita menggunakan kata keterangan (adverb of frequency) seperti always, usually, sometimes, rarely, never dan sebagainya, atau keterangan waktu (adverb of time) seperti every day, every week, twice a week , dan sebagainya.\n" +
                "Contoh :\n" +
                "- I always go to school every 7 o'clock\n" +
                "- My mother cleans the bathroom every twice a week\n\n" +
                "2. Untuk menjelaskan fenomena alam yang berhubungan dengan ilmu pengetahuan atau geografi yang merupakan kebenaran fakta (general truth).\n" +
                "Contoh :\n" +
                "- The sun rises in the east.\n" +
                "- Water boils at 100 degress celcius.\n\n" +
                "3. Untuk menjelaskan segala sesuatu yang permanen. Misalnya tempat tinggal, pekerjaan, kemampuan dan sebagainya.\n" +
                "Contoh :\n" +
                "- My uncle lives in Garut.\n" +
                "- I work as a teacher.\n\n" +
                "4. Untuk mengekpresikan opini, ide, persetujuan dan lain-lain dengan mengguunakan kata kerja statif (stative verbs) yaitu kata kerja yang tidak bisa dibentuk bentuk continuous (verb + ing). Kata-kata kerja itu adalah think, believe, understand dan sebagainya.\n" +
                "Contoh :\n" +
                "- I think he is a good boy.\n" +
                "- She believes whatever I say."
    }
}