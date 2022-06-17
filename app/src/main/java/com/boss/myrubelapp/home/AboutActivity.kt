package com.boss.myrubelapp.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        showUser()

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    fun showUser() {
        tvName.text = "Prasuci Nanda Minova"
        tvNim.text = "2517134"
        tentangSaya.text = "Mahasiswa Program Studi Pendidikan Teknik Informatika dan Komputer, " +
                "Fakultas Tarbiyah dan Ilmu Keguruan, IAIN Bukittinggi angkatan 2017 \nDeveloper RuBel"
        tvAboutRubel.text = "RuBel atau Ruang Belajar merupakan aplikasi mobile learning yang bertujuan untuk membantu guru dan murid kelas 7 di MTs " +
                "Tabek pada mata pelajaran Bahasa Inggris semester 1. "

        Glide.with(this)
            .load(R.drawable.sucici)
            .apply(RequestOptions.circleCropTransform())
            .into(ivUser)
    }
}