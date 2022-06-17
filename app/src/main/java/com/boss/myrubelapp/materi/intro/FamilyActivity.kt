package com.boss.myrubelapp.materi.intro

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import com.boss.myrubelapp.R
import com.google.android.youtube.player.YouTubeBaseActivity
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import kotlinx.android.synthetic.main.activity_family.*

class FamilyActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "EgROxMZEBN4"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_family)
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

        showFamily()
    }

    @SuppressLint("SetTextI18n")
    fun showFamily() {
        tvNuclear.text = "Dalam bahasa Indonesia Core atau Nuclear Family adalah keluarga inti.\n\n Father = ayah\n" +
                "Mother = ibu\n" +
                "Brother = saudara laki-laki\n" +
                "Sister = saudara perempuan\n" +
                "Husband = suami\n" +
                "Wife = istri\n" +
                "Child/children = anak\n" +
                "Son = anak laki-laki\n" +
                "Daughter = anak perempuan \n\n"+
                "kalau seandainya kita punya saudara kandung (siblings)yang lebih muda atau tua bagaimana cara membedakannya? Karena kakak pastinya lebih tua, maka kita hanya perlu menambahkan older, elder, atau big sebelum kata brother. Sedangkan untuk adik, kita hanya perlu menambahkan kaya younger atau little, seperti ini:\n\n"+
                "Big/older/elder brother= kakak laki-laki\n" +
                "Big/older/elder sister = kakak perempuan\n" +
                "Younger/little brother = adik laki-laki\n" +
                "Younger/little sister = adik perempuan"

        tvExtended.text = "Extended family adalah keluarga besar yang mencakup keluarga inti dan saudara lainnya yang sedarah.\n\nGrandfather= kakek\n" +
                "Grandmother= nenek\n" +
                "Uncle= paman\n" +
                "Aunt= bibi\n" +
                "Cousin= sepupu\n" +
                "Nephew= keponakan laki-laki\n" +
                "Niece= keponakan perempuan"

        tvLaw.text = "Family in Laws memiliki arti anggota keluarga yang tidak memiliki hubungan darah dengan kita.\n\nFather-in-law= ayah mertua\n" +
                "Mother-in-law= ibu mertua\n" +
                "Son-in-law= menantu laki-laki\n" +
                "Daughter-in-law= menantu perempuan\n" +
                "Brother-in-law=kakak/adik ipar laki-laki\n" +
                "Sister-in-law= kakak/adik ipar perempuan"
    }
}