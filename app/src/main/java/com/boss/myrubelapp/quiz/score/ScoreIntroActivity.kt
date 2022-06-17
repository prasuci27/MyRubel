package com.boss.myrubelapp.quiz.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Nilai
import com.boss.myrubelapp.quiz.adapter.ScoreAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_score_intro.*

class ScoreIntroActivity : AppCompatActivity() {

    companion object {
        val TAG = "score intro"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_score_intro)

        supportActionBar?.title="Quiz Introduction"

        getNilai()
    }

    private fun getNilai() {
        val ref = FirebaseDatabase.getInstance().getReference("nilai-intro")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                snapshot.children.forEach {
                    Log.d(TAG, "NILAI SISWA MUNCUL")
                    val score = it.getValue(Nilai::class.java)
                    if (score != null) {
                        adapter.add(ScoreAdapter(score))
                    }
                }
                rvScoreIntro.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}