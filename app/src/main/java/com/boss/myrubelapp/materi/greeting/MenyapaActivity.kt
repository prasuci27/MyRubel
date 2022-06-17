package com.boss.myrubelapp.materi.greeting

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_menyapa.*

class MenyapaActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "4LLRkQoW5s4"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menyapa)

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

        showLesson()

    }

    @SuppressLint("SetTextI18n")
    fun showLesson () {
        tvGreeting.text = "Hello/Hi! (Halo/Hai!)\nGood Morning (Selamat Pagi)\nGood Afternoon (Selamat Siang)\nGood Evening (Selamat Sore)\nGood Night (Selamat Malam)\nHello, how are you ? (halo apa kabarmu?)\nHow are you doing ? (Bagaimana kabarmu?)\nGood to see you (Senang bertemu kamu)"
        tvResponse.text = "Hello/Hi! (Halo/Hai!)\nGood Morning (Selamat Pagi)\nGood Afternoon (Selamat Siang)\nGood Evening (Selamat Sore)\nGood Night (Selamat Malam)\nI'm fine thank you (Aku baik, terima kasih)\nPretty well, What about you? (Sangat baik, bagaimana denganmu?)\nGood to see you too (Senang bertemu denganmu juga)"
    }
}