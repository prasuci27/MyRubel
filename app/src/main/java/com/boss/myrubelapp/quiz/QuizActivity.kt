package com.boss.myrubelapp.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import com.boss.myrubelapp.quiz.score.ScoreGreetActivity
import com.boss.myrubelapp.quiz.score.ScoreIntroActivity
import com.boss.myrubelapp.quiz.score.ScoreTimeActivity
import com.boss.myrubelapp.quiz.score.ScoreWorldActivity
import com.boss.myrubelapp.quiz.soal.QuizGreetingActivity
import com.boss.myrubelapp.quiz.soal.QuizIntroActivity
import com.boss.myrubelapp.quiz.soal.QuizTimeActivity
import com.boss.myrubelapp.quiz.soal.QuizWorldActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        val uid = FirebaseAuth.getInstance().uid
        val key = "nIsPVMpLYSdxhZCIUz2lAsbDOKg1"

        cardGreetings.setOnClickListener {
            if (uid == key){
                startActivity(Intent(this, ScoreGreetActivity::class.java))
            } else {
                startActivity(Intent(this, QuizGreetingActivity::class.java))
            }
        }

        cardIntroduction.setOnClickListener {
            if (uid == key) {
                startActivity(Intent(this, ScoreIntroActivity::class.java))
            } else {
                startActivity(Intent(this, QuizIntroActivity::class.java))
            }
        }

        cardTime.setOnClickListener {
            if (uid == key) {
                startActivity(Intent(this, ScoreTimeActivity::class.java))
            } else {
                startActivity(Intent(this, QuizTimeActivity::class.java))
            }
        }

        cardWorld.setOnClickListener {
            if (uid == key) {
                startActivity(Intent(this, ScoreWorldActivity::class.java))
            } else {
                startActivity(Intent(this, QuizWorldActivity::class.java))
            }

        }
    }
}