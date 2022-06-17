package com.boss.myrubelapp.quiz.adapter

import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.Nilai
import com.xwray.groupie.Item
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.nilai_row.view.*

class ScoreAdapter (val nilai : Nilai) : Item<ViewHolder>() {
    override fun bind(viewHolder: ViewHolder, position: Int) {
        viewHolder.itemView.tvNama.text = nilai.namaSiswa
        viewHolder.itemView.tvNamaQuiz.text = nilai.namaQuiz
        viewHolder.itemView.tvNilai.text = nilai.nilai
    }

    override fun getLayout(): Int {
        return R.layout.nilai_row
    }
}