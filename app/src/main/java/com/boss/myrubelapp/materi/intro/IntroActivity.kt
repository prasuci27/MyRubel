package com.boss.myrubelapp.materi.intro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_intro.*

class IntroActivity : AppCompatActivity() {

    private var title = "This is me !"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intro)

        setActionBarTitle(title)

        cardIntro.setOnClickListener {
            val intro = Intent(this, IntroductionActivity::class.java)
            startActivity(intro)
        }

        cardInformation.setOnClickListener {
            val info = Intent(this, InformationActivity::class.java)
            startActivity(info)
        }

        cardFamily.setOnClickListener {
            val family = Intent(this, FamilyActivity::class.java)
            startActivity(family)
        }

        cardSimple.setOnClickListener {
            val simple = Intent(this, PresentActivity::class.java)
            startActivity(simple)
        }

        cardPronoun.setOnClickListener {
            val pronoun = Intent(this, PronounActivity::class.java)
            startActivity(pronoun)
        }

    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

}