package com.boss.myrubelapp.home

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.boss.myrubelapp.R
import kotlinx.android.synthetic.main.activity_kurikulum.*

class KurikulumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kurikulum)

        showKompetensi()

        btnBack.setOnClickListener {
            onBackPressed()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun showKompetensi() {
        tvKInti.text = "KI 1 dan KI 2 : \n Menghargai dan menghayati ajaran agama yang dianutnya serta Menghargai dan menghayati perilaku jujur, " +
                "disiplin, santun, percaya diri, peduli, dan bertanggung jawab dalam berinteraksi secara efektif sesuai dengan perkembangan anak di lingkungan, keluarga, sekolah," +
                "masyarakat dan lingkungan alam sekitar, bangsa, negara, dan kawasan regional. \n\n" +
                " KI 3 : \n Memahami dan menerapkan pengetahuan faktual, konseptual, prosedural, dan metakognitif pada tingkat teknis dan spesifik sederhana berdasarkan rasa ingin" +
                "tahunya tentang ilmu pengetahuan, teknologi, seni, budaya dengan wawasan kemanusiaan, kebangsaan, dan kenegaraan terkait fenomena dan kejadian tampak mata. \n\n" +
                "KI 4 : \n Menunjukkan keterampilan menalar, mengolah, dan menyaji secara kreatif, produktif, kritis, mandiri, kolaboratif, dan komunikatif, dalam ranah konkret dan ranah abstrak" +
                "sesuai dengan yang dipelajari di sekolah dan sumber lain yang sama dalam sudut pandang teori."

        tvKDasar.text = "3.1 Mengidentifikasi fungsi sosial, struktur teks, dan unsur kebahasaan teks interaksi interpersonal lisan dan tulis yang melibatkan tindakan" +
                "menyapa, berpamitan, mengucapkan terimakasih, dan meminta maaf, serta menganggapnya, sesuai dengan konteks penggunaannya. \n\n" +
                "4.1 Menyusun teks interaksi interpersonal lisan dan tulis sangat pendek dan sederhana yang melibatkan tidakan menyapa, berpamitan, mengucapkan terimakasih" +
                "dan meminta maaf, dan menanggapinya dengan memperhatikan fungsi sosial, struktur teks, dan unsur kebahasaan yang benar dan sesuai konteks. \n\n" +
                "3.2 Mengidentifikasi fungsi sosial, struktur teks, dan unsur kebahasaan teks interaksi transaksional lisan dan tulis yang melibatkan tindakan memberi dan meminta infomasi " +
                "terkait jati diri, pendek dan sederhana, sesuai dengan konteks penggunaannya. Perhatikan unsur kebahasaan dan kosa kata terkait hubungan keluarga :" +
                "pronoun (subjective, objective, possessive).\n\n" +
                "4.2 Menyusun teks interaksi transaksional lisan dan tulis sangat pendek dan sederhana yang melibatkan tindakan memberi dan meminta informasi terkait jati diri," +
                "pendek dan sederhana, dengan memperhatikan fungsi sosial, struktur teks, dan unsur kebahasaan yang benar dan sesuai konteks.\n\n"+
                "3.3 Mengidentifikasi fungsi sosial, struktur teks, dan unsur kebahasaan teks interaksi transaksional lisan dan tulis yang melibatkan tindakan memberi dan meminta " +
                "informasi terkait nama hari, bulan, nama waktu dalam hari, waktu dalam bentuk angka, tanggal, dan tahun, sesuai dengan konteks penggunaannya. (Perhatikan kosa kata terkait angka kardinal dan ordinal) \n\n"+
                "4.3 Menyusun teks interaksi transaksional lisan dan tulis pendek dan sederhana yang melibatkan tindakan memberi dan meminta informasi terkait" +
                "nama hari, bulan, nama waktu dalam hari, waktu dalam bentuk angka, tanggal dan tahun, dengan fungsi sosial, struktur teks, dan unsur kebahasaan yang benar dan sesuai konteks.\n\n" +
                "3.4 Mengidentifikasi fungsi sosial, struktur teks, dan unsur kebahasaan teks interaksi traksaksional lisan dan tulis yang melibatkan tindakan member" +
                "dan meminta informasi terkait nama dan jumlah binatang, benda, dan bangunan publik yang dekat dengan kehidupan siswa sehari-hari, sesua dengan konteks" +
                "penggunaannya. (Perhatikan unsur kebahasaan dan kosa kata terkait article a/an dan the, pluran dan singular).\n\n" +
                "4.4 Menyusun teks interaksi transaksional lisan dan tulis sangat pendek dan sederhana yang melibatkan tindakan memberi dan meminta informasi terkait nama dan jumlah" +
                "binatang, benda, dan bangunan publik yang dekat dengan kehidupan siswa sehari-hari, dengan memperhatikan fungsi sosial, struktur teks, dan unsur kebahasaan yang benar dan " +
                "sesuai konteks."
    }
}