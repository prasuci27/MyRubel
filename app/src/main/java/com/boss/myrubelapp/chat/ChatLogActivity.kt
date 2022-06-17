package com.boss.myrubelapp.chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.ChatMessage
import com.boss.myrubelapp.model.User
import com.boss.myrubelapp.notification.PushNotification
import com.boss.myrubelapp.notification.RetrofitInstance
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.gson.Gson
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ChatLogActivity : AppCompatActivity() {

    companion object{
        const val TAG = "ChatLog"
    }

     val adapter = GroupAdapter<ViewHolder>()

    var toUser : User? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        recyclerview_chat_log.adapter = adapter

        toUser = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)
        supportActionBar?.title = toUser?.username

        //setupDummyData()
        listenForMessages()
        btnSend.setOnClickListener {
            Log.d(TAG, "pesan terkirim")
            performSendChat()
//            PushNotification(NotificationData())
        }
    }

    private fun listenForMessages() {
        val fromId = FirebaseAuth.getInstance().uid
        val toId = toUser?.uid
        val ref = FirebaseDatabase.getInstance().getReference("/user-messages/$fromId/$toId")

        ref.addChildEventListener(object : ChildEventListener {
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
             val chatMessage = snapshot.getValue(ChatMessage::class.java)

                if (chatMessage != null) {
                    Log.d(TAG, chatMessage.text)

                    if (chatMessage.fromId == FirebaseAuth.getInstance().uid) {
                        val currentUser = ChatActivity.currentUser ?: return
                        adapter.add(ChatFromItem(chatMessage.text, currentUser))
                    } else {
                        adapter.add(ChatToItem(chatMessage.text, toUser!!))
                    }
                }

                recyclerview_chat_log.scrollToPosition(adapter.itemCount -1)
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onChildRemoved(snapshot: DataSnapshot) {}

            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}

            override fun onCancelled(error: DatabaseError) {}

        })
    }

    private fun performSendChat() {
        //sending message by firebase
        val text = edittext_chat_log.text.toString()

        val fromId = FirebaseAuth.getInstance().uid
        val user = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)
        val toId = user?.uid

        if (fromId == null) return

        //val reference = FirebaseDatabase.getInstance().getReference("/messages").push()
        val reference = FirebaseDatabase.getInstance().getReference("/user-messages/$fromId/$toId").push()
        val toReference = FirebaseDatabase.getInstance().getReference("/user-messages/$toId/$fromId").push()
        val chatMessage = ChatMessage(reference.key!!, text, fromId, toId!!, System.currentTimeMillis() / 1000)

        reference.setValue(chatMessage)
                .addOnSuccessListener {
                    Log.d(TAG, "Save our chat : ${reference.key}")
                    edittext_chat_log.text.clear()
                    recyclerview_chat_log.scrollToPosition(adapter.itemCount - 1)
                }
        toReference.setValue(chatMessage)

        val latestChatRef = FirebaseDatabase.getInstance().getReference("/latest-messages/$fromId/$toId")
        latestChatRef.setValue(chatMessage)

        val latestChatToRef = FirebaseDatabase.getInstance().getReference("/latest-messages/$toId/$fromId")
        latestChatToRef.setValue(chatMessage)
    }

    private fun sendNotification(notification : PushNotification) = CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = RetrofitInstance.api.postNotification(notification)
            if (response.isSuccessful) {
                Log.d(TAG, "Response : ${Gson().toJson(response)}")
            } else {
                Log.e(TAG, response.errorBody()!!.string())
            }
        } catch (e: Exception) {
            Log.e(TAG, e.toString())
        }
    }

}

