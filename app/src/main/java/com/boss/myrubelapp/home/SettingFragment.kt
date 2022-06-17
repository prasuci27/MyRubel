package com.boss.myrubelapp.home

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.boss.myrubelapp.R
import com.boss.myrubelapp.model.User
import com.boss.myrubelapp.sign.signin.SignInActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.android.synthetic.main.fragment_setting.*


class SettingFragment : Fragment() {

    companion object {
        val TAG = "setting"
        var currentUser : User ? = null
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setting, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        tvLogOut.setOnClickListener {
            //logout
            FirebaseAuth.getInstance().signOut()
            //back to sign in
            Intent(activity, SignInActivity::class.java).also{
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        tvAbout.setOnClickListener {
            startActivity(Intent(activity, AboutActivity::class.java))
        }

        fetchData()
    }

    private fun fetchData() {
        val uid = FirebaseAuth.getInstance().uid
        val ref = FirebaseDatabase.getInstance().getReference("/User/$uid")
        ref.addListenerForSingleValueEvent(object : ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
              currentUser = snapshot.getValue(User::class.java)
                Log.d(TAG, "setting user ${currentUser?.username}")

                tv_username.text = currentUser?.username
                tv_nama.text = currentUser?.nama

                Glide.with(this@SettingFragment)
                    .load(currentUser?.photoUrl)
                    .apply(RequestOptions.circleCropTransform())
                    .into(iv_profile)
            }
            override fun onCancelled(error: DatabaseError) {
            }
        })
    }
}