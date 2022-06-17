package com.boss.myrubelapp.materi.world

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_plural_noun.*

class PluralNounActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "UkZVdY960-8"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plural_noun)

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

        showPlural()
    }

    @SuppressLint("SetTextI18n")
    fun showPlural() {
        tvPluralExplain.text = "Plural nouns digunakan untuk benda-benda yang berjumlah lebih dari satu. Kata benda akan diikuti tambahan berupa '-s' atau '-es'.\n" +
                "Penggunaan kedua tambahan ini tidak bisa sembarangan. Kebanyakan kata benda bisa langsung ditambah dengan '-s'. Contohnya: Cat = cats Boat = boats river = rivers Kata dengan akhiran s, x, z, ch, dan sh ditambah dengan '-es'. Contohnya: Bus = buses Box = boxes Lunch = lunches Wish = wishes\n" +
                "\n" + "Kata dengan akhiran 'y' tetapi huruf sebelumnya vokal, ditambah dengan '-s'. Contohnya: Ray = rays Boy = boys Kata dengan akhiran 'y' tetapi huruf sebelumnya konsonan, ditambah dengan '-es'. Contohnya: Penny = pennies Puppy = puppies \n"

        tvIrregular.text = "Ada beberapa noun yang tidak menggunakan tambahan. Sebagian kata benda tidak berubah dari kata aslinya. Sebagian lahi berubah dari kata aslinya.\n\n"+
                "Kata yang tidak berubah contohnya : Fish, deer, sheep, species dan aircraft\n\n" +
                "Irregular nouns, seperti : \n" +
                "- Woman = women \n" +
                "- Child = children\n"+
                "- Foot = feet\n"+
                "- Tooth = teeth\n"+
                "- Mouse = mice\n"
    }
}