package com.boss.myrubelapp.materi.days

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_day.*

class DayActivity : AppCompatActivity() {

    private var title = "What time is it?"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_day)

        setActionBarTitle(title)

        cardTime.setOnClickListener {
            val time = Intent(this, TimeActivity::class.java)
            startActivity(time)
        }

        cardPrepo.setOnClickListener {
            val preposition = Intent(this, PrepositionActivity::class.java)
            startActivity(preposition)
        }

        cardClock.setOnClickListener {
            val clock = Intent(this, OclockActivity::class.java)
            startActivity(clock)
        }

        cardNumber.setOnClickListener {
            val number = Intent(this, NumberActivity::class.java)
            startActivity(number)
        }


    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }
}