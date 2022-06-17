package com.boss.myrubelapp.notification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Announcement
import com.boss.myrubelapp.notification.adapter.AnnounceAdapter
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_announce_list.*

class AnnounceListActivity : AppCompatActivity() {

    companion object {
        val TAG = "announcement"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announce_list)

        getAnnounce()
    }

    private fun getAnnounce() {
        val ref = FirebaseDatabase.getInstance().getReference("announcement")
        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val adapter = GroupAdapter<ViewHolder>()

                snapshot.children.forEach {
                    Log.d(TAG, "PENGUMUMAN SISWA MUNCUL")
                    val announce = it.getValue(Announcement::class.java)
                    if (announce != null) {
                        adapter.add(AnnounceAdapter(announce))
                    }
                }
                rvAnnouncement.adapter = adapter
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }
}