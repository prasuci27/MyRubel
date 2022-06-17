package com.boss.myrubelapp.chat

import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.User
import com.squareup.picasso.Picasso
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

class ChatFromItem (val text : String, val user : User): Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvFromRow.text = text

        val uri = user.photoUrl
        val targetImageView = viewHolder.itemView.ivPhotoFromRow
        Picasso.get().load(uri).into(targetImageView)
    }

    override fun getLayout(): Int {
        return  R.layout.chat_from_row
    }

}

class ChatToItem (val text: String, val user: User) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvToRow.text = text
        //load user image using glide or picaso
        val uri = user.photoUrl
        val targetImageView = viewHolder.itemView.ivPhotoToRow
        Picasso.get().load(uri).into(targetImageView)

    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}
