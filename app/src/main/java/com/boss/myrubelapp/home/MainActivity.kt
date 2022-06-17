package com.boss.myrubelapp.home

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.boss.myrubelapp.R
import com.boss.myrubelapp.chat.ChatActivity
import com.boss.myrubelapp.sign.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentHome = DashboardFragment()
        val fragmentSetting = SettingFragment()

        setFragment(fragmentHome)

       iv_menu1.setOnClickListener {
           setFragment(fragmentHome)

           changeIcon(iv_menu1, R.drawable.ic_home_active)
           changeIcon(iv_menu2, R.drawable.ic_chat)
           changeIcon(iv_menu3, R.drawable.ic_profile)
       }

        iv_menu2.setOnClickListener {
           val chat = Intent(this, ChatActivity::class.java)
            startActivity(chat)
       }

        iv_menu3.setOnClickListener {
           setFragment(fragmentSetting)

           changeIcon(iv_menu1, R.drawable.ic_home)
           changeIcon(iv_menu2, R.drawable.ic_chat)
           changeIcon(iv_menu3, R.drawable.ic_profile_active)
       }

        verifyUserLogin()

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_frame, fragment)
        fragmentTransaction.commit()
    }

    private fun changeIcon(imageView: ImageView, int: Int) {
        imageView.setImageResource(int)
    }

    private fun verifyUserLogin() {
        val uid = FirebaseAuth.getInstance().uid
        if (uid == null) {
            val intent = Intent(this, SignInActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)
        }
    }

}


