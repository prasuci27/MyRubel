package com.boss.myrubelapp.materi.world

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_noun.*

class NounActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_noun)

        showNoun()
    }

    @SuppressLint("SetTextI18n")
    fun showNoun() {
        tvLiving.text = "- Two bags = dua tas\n" +
                "- Some pictures = beberapa foto/gambar\n" +
                "- Many books = banyak buku-buku\n" +
                "- A lamp = sebuah lampu\n" +
                "- A bookcase = sebuah lemari buku\n" +
                "- A telephone = sebuah telepon\n" +
                "- A sofa = sebuha sofa\n" +
                "- A table = sebuah meja\n" +
                "- A carpet = sebuah karpet\n"+
                "- A television = sebuah televisi\n" +
                "- A pair of curtains = sepasang tirai"

        tvKitchen.text = "- A sink = sebuah wastafel\n" +
                "- A frying pan = sebuah panci penggorengan\n" +
                "- A pan = sebuah panci\n" +
                "- An oven = sebuah oven\n" +
                "- A stove = sebuah kompor\n"+
                "- A refrigerator = sebuah kulkas\n"+
                "- A cabinet = sebuah lemari"
    }
}