package com.boss.myrubelapp.absen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Absen
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_absen.*

class AbsenActivity : AppCompatActivity() {

    companion object {
        const val TAG = "list absen"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_absen)

        supportActionBar?.title = "Absen Siswa"


        getAbsen()
    }

    val adapter = GroupAdapter<ViewHolder>()

    private fun getAbsen() {
        val ref = FirebaseDatabase.getInstance().getReference("user-absen")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                snapshot.children.forEach {
                    Log.d(TAG, "ABSEN SISWA MUNCUL")
                    val listAbsen = it.getValue(Absen::class.java)
                    if (listAbsen != null) {
                        adapter.add(AbsenAdapter(listAbsen))
                    }
                }
                rvAbsen.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}