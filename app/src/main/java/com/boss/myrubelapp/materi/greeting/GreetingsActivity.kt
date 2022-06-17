package com.boss.myrubelapp.materi.greeting

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_greetings.*

class GreetingsActivity : AppCompatActivity() {

    private var title = "Greetings"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greetings)
        setActionBarTitle(title)

        card_greeting.setOnClickListener {
            val greeting = Intent(this, MenyapaActivity::class.java)
            startActivity(greeting)
        }

        card_gratitude.setOnClickListener {
            val gratitude = Intent(this, GratitudeActivity::class.java)
            startActivity(gratitude)
        }

        card_apologize.setOnClickListener {
            val apology = Intent(this, ApologyActivity::class.java)
            startActivity(apology)
        }
    }


    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

}