package com.boss.myrubelapp.materi.days

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_time.*

class TimeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_time)

        showTime()
    }

    @SuppressLint("SetTextI18n")
    fun showTime() {
        tvName_Day.text = "Monday = Senin\n" +
                "\n" +
                "Tuesday = Selasa\n" +
                "\n" +
                "Wednesday = Rabu\n" +
                "\n" +
                "Thursday = Kamis\n" +
                "\n" +
                "Friday = Jumat\n" +
                "\n" +
                "Saturday = Sabtu\n" +
                "\n" +
                "Sunday = Minggu"

        tvMonth.text = "January = Januari\n" +
                "\n" +
                "February = Februari\n" +
                "\n" +
                "March = Maret\n" +
                "\n" +
                "April = April\n" +
                "\n" +
                "May = Mei\n" +
                "\n" +
                "June = Juni\n" +
                "\n" +
                "July = Juli\n" +
                "\n" +
                "August = Augustus\n" +
                "\n" +
                "September = September\n" +
                "\n" +
                "October = Oktober\n" +
                "\n" +
                "November = November\n" +
                "\n" +
                "December = Desember"

        tvWord.text = "Today is Monday (Hari ini adalah hari senin)\n" +
                "\n" +
                "Yesterday was Sunday (Kemarin adalah hari selasa)\n" +
                "\n" +
                "Tomorrow will be Tuesday (Besok adalah hari selasa)\n" +
                "\n" +
                "The day after tomorrow will be Wednesday (Lusa adalah hari rabu)\n" +
                "\n" +
                "I go to school every Monday until Friday (aku pergi ke sekolah setiap hari senin sampai jumat)\n" +
                "\n" +
                "The third month is March (bulan ketiga adalah maret)\n" +
                "\n" +
                "Before January is December (sebelum januari adalah desember)\n" +
                "\n" +
                "After April is May (setelah april adalah mei)\n" +
                "\n" +
                "March is my birthday month (maret adalah bulan ulang tahunku)"
    }
}