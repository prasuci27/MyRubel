package com.boss.myrubelapp.chat

import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.ChatMessage
import com.boss.myrubelapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.latest_chat_row.view.*

class LastestChatRow (private val chatMessage: ChatMessage): Item<ViewHolder>() {

    var chatPartnerUser : User? = null

    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.message_textview_latest_message.text = chatMessage.text

        val chatPartnerId: String = if (chatMessage.fromId == FirebaseAuth.getInstance().uid) {
            chatMessage.toId
        } else {
            chatMessage.fromId
        }

        val ref = FirebaseDatabase.getInstance().getReference("/User/$chatPartnerId")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                chatPartnerUser = snapshot.getValue(User::class.java)
                viewHolder.itemView.username_textview_latest_message.text = chatPartnerUser?.username

                val targetImageView = viewHolder.itemView.imageview_latest_message
                Picasso.get().load(chatPartnerUser?.photoUrl).into(targetImageView)
            }

            override fun onCancelled(error: DatabaseError) {
            }

        })
    }

    override fun getLayout(): Int {
        return R.layout.latest_chat_row
    }
}