package com.boss.myrubelapp.home

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.boss.myrubelapp.R
import com.boss.myrubelapp.absen.AbsenActivity
import com.boss.myrubelapp.absen.AmbilAbsenActivity
import com.boss.myrubelapp.materi.days.DayActivity
import com.boss.myrubelapp.materi.greeting.GreetingsActivity
import com.boss.myrubelapp.materi.intro.IntroActivity
import com.boss.myrubelapp.materi.world.WorldActivity
import com.boss.myrubelapp.model.User
import com.boss.myrubelapp.quiz.QuizActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    companion object {
        val TAG = "dashboard"
        var currentUser: User? = null
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_dashboard, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val uid = FirebaseAuth.getInstance().uid
        val key = "nIsPVMpLYSdxhZCIUz2lAsbDOKg1"

        cardGreetings.setOnClickListener {
            startActivity(Intent(activity, GreetingsActivity::class.java))
        }

        cardIntroduction.setOnClickListener {
            startActivity(Intent(activity, IntroActivity::class.java))
        }

        cardTime.setOnClickListener {
            startActivity(Intent(activity, DayActivity::class.java))
        }

        cardWorld.setOnClickListener {
            startActivity(Intent(activity, WorldActivity::class.java))
        }

        cardQuiz.setOnClickListener {
            startActivity(Intent(activity, QuizActivity::class.java))
        }

        cardAbsen.setOnClickListener {
            if (uid == key) {
                startActivity(Intent(activity, AbsenActivity::class.java))
            } else {
                startActivity(Intent(activity, AmbilAbsenActivity::class.java))
            }
        }

        tvKIKD.setOnClickListener {
            startActivity(Intent(activity, KurikulumActivity::class.java))
        }


    }
}



