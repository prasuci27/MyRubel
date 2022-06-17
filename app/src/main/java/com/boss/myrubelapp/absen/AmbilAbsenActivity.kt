package com.boss.myrubelapp.absen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Absen
import com.boss.myrubelapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.activity_ambil_absen.*
import kotlinx.android.synthetic.main.activity_result_intro.*
import java.text.DateFormat
import java.util.*

class AmbilAbsenActivity : AppCompatActivity() {

    companion object {
        const val TAG = "Absen"
        var currentUser : User ? = null
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ambil_absen)
        simpanAbsen()
        getCurrentDate()
        fetchData()
    }

    private fun simpanAbsen() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("user-absen/$uid")

        val hadir = rbHadir.text.toString()
        val sakit = rbSakit.text.toString()
        val izin = rbIzin.text.toString()

        btn_save.setOnClickListener {
            val nama = tv_nama.text.toString()
            val date = tvCurrentDate.text.toString()
            when {
                rbHadir.isChecked -> {
                    val ambilAbsen = Absen(nama, date, hadir)
                    Toast.makeText(this, "Absen Berhasil", Toast.LENGTH_SHORT).show()
                    ref.setValue(ambilAbsen)
                            .addOnSuccessListener {
                                Log.d(TAG, "absen disimpan")
                            }
                            .addOnFailureListener {
                                Log.d(TAG, "gagal input data")
                            }
                }
                rbSakit.isChecked -> {
                    val ambilAbsen = Absen(nama, date, sakit)
                    Toast.makeText(this, "Absen Berhasil", Toast.LENGTH_SHORT).show()
                    ref.setValue(ambilAbsen)
                            .addOnSuccessListener {
                                Log.d(TAG, "absen disimpan")
                            }
                            .addOnFailureListener {
                                Log.d(TAG, "gagal input data")
                            }
                }
                else -> {
                    val ambilAbsen = Absen(nama, date, izin)
                    Toast.makeText(this, "Absen Berhasil", Toast.LENGTH_SHORT).show()
                    ref.setValue(ambilAbsen)
                            .addOnSuccessListener {
                                Log.d(TAG, "absen disimpan")
                            }
                            .addOnFailureListener {
                                Log.d(TAG, "gagal input data")
                            }
                }
            }

        }
    }

    private fun fetchData() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/User/$uid")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                currentUser = snapshot.getValue(User::class.java)
                Log.d(TAG, "absen ${currentUser?.username}")

                tv_nama.text = currentUser?.nama

                Glide.with(this@AmbilAbsenActivity)
                        .load(currentUser?.photoUrl)
                        .apply(RequestOptions.circleCropTransform())
                        .into(iv_profile)
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }

    private fun getCurrentDate() {
        val calendar = Calendar.getInstance()
        val currentDate = DateFormat.getDateInstance(DateFormat.FULL).format(calendar.time)
        tvCurrentDate.text = currentDate
        Log.d(TAG, "tanggal : $currentDate")
    }
}