package com.boss.myrubelapp.materi.world

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_article.*

class ArticleActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "gl3cIR7OH6E"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

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

        showArticle()
    }

    @SuppressLint("SetTextI18n")
    fun showArticle() {
        tvArticle.text = "A/An merupakan kata sandang yang artinya sebuah, seorang, seekor, tergantung apa objek yang ditunjukkannya. Ini berarti a/an menunjukkan hanya ada 1 objek yang ditunjukkan. Lalu apa perbedaan penggunaan a dan an? Perbedaan penggunaannya terletak pada huruf awal dari objek. Article 'a' digunakan untuk kata yang terdengar berawalan konsonan, contohnya; a ball, a dog, a cat, a girl, a man, a university, a european dan lain sebagainya. Sementara article 'an' digunakan untuk kata yang terdengar berawalan huruf vokal, seperti: an apple, an enemy, an old man, an iguana, dan lain sebagainya."

        tvFunction_Article.text = "1. Article a/an digunakan untuk objek singular. Yang mana hanya ada satu noun yang ditunjukkan. A dan an disini berarti sebuah Contohnya seperti:\n" +
                "- My dad bought me a dog\n" +
                "- I bring an apple to school.\n\n" +
                "2. Article a/an digunakan untuk menunjukkan angka misalnya seribu, atau seratus. Contohnya:\n" +
                "- I got a thousand dollars from the lottery.\n" +
                "- There were more than a hundred birds on the island.\n\n" +
                "3. Article a/an digunakan untuk sebelum menyatakan kasta, kelas, dan pekerjaan seseorang atau sesuatu. Contohnya:\n" +
                "- He was a student.\n" +
                "- The truck is a Ford.\n" +
                "- My mother was an accountant.\n\n" +
                "4. Article a/an digunakan pada sebelum menyatakan jumlah dari sesuatu. Contohnya:\n" +
                "- Microsoft has made a lot of money this year.\n" +
                "- I played a pair of aces.\n" +
                "- They found a mound of earth.\n\n" +
                "5. Article a/an digunakan untuk menunjukkan jumlah satuan dari benda. Contohnya:\n" +
                "- The flour costs eighty cents a kilogram\n" +
                "- The bus left the road travelling at one hundred kilometers an hour!"
    }


}