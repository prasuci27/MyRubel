package com.boss.myrubelapp.quiz.nilai

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Nilai
import com.boss.myrubelapp.model.User
import com.boss.myrubelapp.quiz.QuizActivity
import com.boss.myrubelapp.quiz.model_soal.ConstWorld
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_result_world.*

class ResultWorldActivity : AppCompatActivity() {
    companion object {
        val TAG = "Result World"
        var currentUser : User? = null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_world)

        val quizName = intent.getStringExtra(ConstWorld.QUIZ_NAME)
        val correctAnswers = intent.getIntExtra(ConstWorld.CORRECT_ANSWERS, 0) * 10

        tv_score.text =  "$correctAnswers"
        tvQuizName.text = "$quizName"

        btn_finish.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
            inputNilai()
            finish()
        }

        fetchData()
    }

    private fun inputNilai() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("nilai-world/$uid")
        val answer = tv_score.text.toString()
        val quizName = tvQuizName.text.toString()
        val nama = tv_name.text.toString()

        val nilaiQuiz = Nilai(nama,quizName, answer)
        ref.setValue(nilaiQuiz)
            .addOnSuccessListener {
                Log.d(TAG, "nilai disimpan")
            }
            .addOnFailureListener {
                Log.d(TAG, "gagal input data")
            }
    }

    private fun fetchData() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/User/$uid")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                ResultTimeActivity.currentUser = snapshot.getValue(User::class.java)
                Log.d(TAG, "nilai world ${currentUser?.username}")

                tv_name.text = currentUser?.nama

            }
            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}