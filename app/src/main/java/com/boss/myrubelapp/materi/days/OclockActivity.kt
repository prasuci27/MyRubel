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
import kotlinx.android.synthetic.main.activity_oclock.*

class OclockActivity : YouTubeBaseActivity() {

    val VIDEO_ID = "VQVq4xXLhWY"

    lateinit var youtubePlayerInit : YouTubePlayer.OnInitializedListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oclock)

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

        showClock()

    }

    @SuppressLint("SetTextI18n")
    fun showClock() {
        tvTellingTime.text = "Untuk membaca jam ada beberapa hal yang harus kita perhatikan. Kata O'clock digunakan untuk jam tepat, quarter (seperempat) digunakan untuk menyatakan waktu yang kurang atau lebih 15 menit. Sedangkan half (setengah) digunakan untuk menyatakan waktu yang lebih dari 30 menit.\n\n" +
                "- Jam tepat = Jika jam menunjukkan jam tepat/pas (jarum panjang tepat ke angka 12) maka kita harus mengatakan seperti ini:\n" +
                "It's seven o'clock (Jam tujuh tepat 07.00)\n" +
                "It's nine o'clock (Jam sembilan tepat/ 09.00)\n" +
                "It's eleven o'clock (Jam sebelas tepat/ 11.00)\n\n" +
                "- Jam lebih = Jika jarum panjang jam menunjukkan lebih 1-30 menit, maka kita harus mengatakan:\n" +
                "It's ten minutes past nine (Jam 8 lebih sepuluh menit/ 08.10)\n" +
                "It's a quarter past eleven (Jam sebelas lebih lima belas menit/ 11.15)\n" +
                "It's a half past twelve (Jam dua belas lebih tiga puluh menit/ setengah satu / 12.30)\n\n" +
                "- Jam kurang = Jika jarum panjang menunjukkan lebih dari 31 menit ke atas, maka kita harus mengatakan:\n" +
                "It's ten to nine (Jam sembilan kurang sepuluh menit/ 09.50)\n" +
                "It's five to three (Jam tiga kurang lima menit/ 02.55)\n" +
                "It's a quarter to five (Jam lima kurang lima belas menit/ 04.45)"


        tvIstilah.text = "Istilah yang sering muncul :\n\n" +
                "a.m : ante meridiem (dimulai dari jam 12 malam sampai jam 12 siang)\n" +
                "p.m : post meridiem (dimulai dari jam 12 siang sampai jam 12 malam)\n" +
                "Long hand : Jarum panjang\n" +
                "Short hand : Jarum pendek\n" +
                "Second hand : Jarum detik\n" +
                "Alarm clock : Jam beker\n" +
                "Clock : Jam dinding\n" +
                "Watch : Jam tangan\n" +
                "Hour : Jam\n" +
                "Minute : Menit\n" +
                "Second : Detik\n" +
                "O'clock : Digunakan untuk menunjukan jam ketika jarum panjangnya tepat ke jam 12.\n" +
                "Past : Lebih\n" +
                "To : Kurang\n" +
                "A quarter : Seperempat (15 menit)\n" +
                "A half : Setengah (30 menit)"

        tvClockExample.text = "Kalimat untuk menanyakan jam :\n\n" +
                "What time is it now? (Jam berapa sekarang?)\n" +
                "What is the time? (Jam berapa sekarang?)\n" +
                "What time is it right now? (Jam berapa sekarang?)\n" +
                "Do you know what time is it? (Apakah kamu tahu ini jam berapa?)\n" +
                "May I know what time is it? (Bolehkah aku tahu ini jam berapa?)\n" +
                "What time exactly the movie start? (Kapan tepatnya filmnya main?)\n" +
                "When does the store is open? (Kapan tokonya buka?)\n" +
                "When should we meet again? (Kapan kita bisa bertemu?)"
    }
}