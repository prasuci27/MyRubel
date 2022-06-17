package com.boss.myrubelapp.notification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Announcement
import com.boss.myrubelapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_announce.*


class AnnounceActivity : AppCompatActivity() {

    companion object {
        val TAG = "announce"
        var currentUser : User ?= null
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_announce)

//        FirebaseMessaging.getInstance().subscribeToTopic(TOPIC)

        btn_publish.setOnClickListener {
            sendAnnounce()
            startActivity(Intent(this, AnnounceListActivity::class.java))

//            val title = etTitle.text.toString()
//            val message = etAnnounce.text.toString()
//            if (title.isNotEmpty() && message.isNotEmpty()) {
//                PushNotification(
//                    NotificationData(title, message),
//                TOPIC
//                ).also {
//                    sendNotification(it)
//                }
//            }
        }

        //fetchData()
    }

//    private fun sendNotification(notification: PushNotification) = CoroutineScope(Dispatchers.IO).launch {
//        try {
//            val response = RetrofitInstance.api.pushNotification(notification)
//            if (response.isSuccessful) {
//                Log.d(TAG, "Response: ${Gson().toJson(response)}")
//            }
//        } catch (e: Exception) {
//            Log.e(TAG, e.toString())
//        }
//    }

    private fun sendAnnounce() {
      val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("announcement/$uid")

        val topic = etTitle.text.toString()
        val isi = etAnnounce.text.toString()

        val announcement = Announcement(topic, isi)
        ref.setValue(announcement)
            .addOnSuccessListener {
                Log.d(TAG, "announce berhasil")
            }
            .addOnFailureListener {
                Log.d(TAG, "announce gagal")
            }
    }

}