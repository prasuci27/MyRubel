package com.boss.myrubelapp.notification.adapter

import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Announcement
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.announce_row.view.*

class AnnounceAdapter (val announcement : Announcement) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvTopik.text = announcement.topic
        viewHolder.itemView.tvAnnouncement.text = announcement.announce
    }

    override fun getLayout(): Int {
        return R.layout.announce_row
    }
}