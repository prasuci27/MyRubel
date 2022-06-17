package com.boss.myrubelapp.chat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.ChatMessage
import com.boss.myrubelapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_chat.*

class ChatActivity : AppCompatActivity() {

    companion object {
        var currentUser: User? = null
        const val TAG = "LatestMessages"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)
        supportActionBar?.title="RuBel Chat"

        rvLastChat.adapter = adapter
        rvLastChat.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        //set item click user
        adapter.setOnItemClickListener { item, view ->
            Log.d(TAG, "test click")
            val intent = Intent(this, ChatLogActivity::class.java)

            val row = item as LastestChatRow

            intent.putExtra(NewMessageActivity.USER_KEY,  row.chatPartnerUser)
            startActivity(intent)
        }

        listenForLatestChat()
        fetchCurrentUser()

        btnNewChat.setOnClickListener {
            startActivity(Intent(this, NewMessageActivity::class.java))
        }
    }

    val latestChatMap = HashMap<String, ChatMessage>()

    private fun refreshRvChat() {
        adapter.clear()
        latestChatMap.values.forEach {
            adapter.add(LastestChatRow(it))
        }
    }

    //menampilkan user terakhir
    private fun listenForLatestChat() {
        val fromId = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/latest-messages/$fromId")
        ref.addChildEventListener(object : ChildEventListener{
            override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {
                val chatMessage = snapshot.getValue(ChatMessage::class.java) ?: return
                latestChatMap[snapshot.key!!] = chatMessage
                refreshRvChat()
            }

            override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {
                val chatMessage = snapshot.getValue(ChatMessage::class.java) ?: return
                latestChatMap[snapshot.key!!] = chatMessage
                refreshRvChat()
            }

            override fun onChildRemoved(snapshot: DataSnapshot) {}
            override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {}
            override fun onCancelled(error: DatabaseError) {}

        })
    }

    val adapter = GroupAdapter<ViewHolder>()

    private fun fetchCurrentUser() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/User/$uid")

        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                currentUser = snapshot.getValue(User::class.java)
                Log.d(TAG, "Current user ${currentUser?.photoUrl}")
            }

            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}