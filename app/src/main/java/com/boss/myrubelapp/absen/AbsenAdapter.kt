package com.boss.myrubelapp.absen

import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Absen
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.absen_item.view.*

class AbsenAdapter (val absen : Absen) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvNamaSiswa.text = absen.namaSiswa
        viewHolder.itemView.tvKeterangan.text = absen.ket
        viewHolder.itemView.tvDate.text = absen.date
    }

    override fun getLayout(): Int {
        return R.layout.absen_item
    }
}