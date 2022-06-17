package com.boss.myrubelapp.materi.world

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_world.*

class WorldActivity : AppCompatActivity() {

    private var title = "This is my world"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_world)

        setActionBarTitle(title)

        cardEnvironment.setOnClickListener {
            val environment = Intent(this, NounActivity::class.java)
            startActivity(environment)
        }

        cardArticle.setOnClickListener {
            val article = Intent(this, ArticleActivity::class.java)
            startActivity(article)
        }

        cardNoun.setOnClickListener {
            val noun = Intent(this, PluralNounActivity::class.java)
            startActivity(noun)
        }

        cardDemo.setOnClickListener {
            val demo = Intent(this, DemonstrativeActivity::class.java)
            startActivity(demo)
        }


    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}