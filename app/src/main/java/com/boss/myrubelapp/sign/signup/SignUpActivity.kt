package com.boss.myrubelapp.sign.signup

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.boss.myrubelapp.R
import com.boss.myrubelapp.home.MainActivity
import com.boss.myrubelapp.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import kotlinx.android.synthetic.main.activity_sign_up.*
import java.util.*

class SignUpActivity : AppCompatActivity() {

    companion object {
        val TAG = "RegisterActivity"
    }

    lateinit var sName : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        btn_next.setOnClickListener {
            val user = User()
            performRegister()
        }

        btnBack.setOnClickListener {
            onBackPressed()
        }

        ivProfile.setOnClickListener {
            Log.d(TAG, "pilih photo")


            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }

    }

    var selectedPhotoUri : Uri? = null
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null) {
            Log.d(TAG, "Photo was selected")

            selectedPhotoUri = data.data

            Glide.with(this)
                    .load(selectedPhotoUri)
                    .apply(RequestOptions.circleCropTransform())
                    .into(ivProfile)
        } else {
            Log.d(TAG, "Gagal menambahkan photo")
        }
    }

    private fun performRegister() {
        val email = etEmail.text.toString()
        val password = etPassword.text.toString()

        if (email.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Silahkan masukkan email/password anda!!", Toast.LENGTH_SHORT).show()
            return
        }
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    if (!it.isSuccessful) return@addOnCompleteListener
                    Log.d("SignUpActivity", "Berhasil membuat akun")
                    val firebaseUser : FirebaseUser = it.result!!.user!!
                    val intent = Intent(this@SignUpActivity, MainActivity::class.java)
                    intent.putExtra("uid", firebaseUser.uid)
                    intent.putExtra("email", firebaseUser.email)
                    startActivity(intent)
                    uploadImage()
                    finish()
                }
                .addOnFailureListener {
                    Log.d("SignUp", "Gagagl membuat akun")
                }
    }

    private fun uploadImage() {
        if (selectedPhotoUri == null) return
        val fileName = UUID.randomUUID().toString()
        val ref = FirebaseStorage.getInstance().getReference("/images/$fileName")

        ref.putFile(selectedPhotoUri!!)
                .addOnSuccessListener {
                    Log.d(TAG, "Berhasil upload gambar : ${it.metadata?.path}")
                    ref.downloadUrl.addOnSuccessListener {
                        it.toString()
                        Log.d(TAG, "File Location : $it")
                        saveUser(it.toString())
                    }
                }
                .addOnFailureListener {

                }
    }

    private fun saveUser(photoUrl : String) {
        val username = etUsername.text.toString()
        val name = etName.text.toString()

        val uid = FirebaseAuth.getInstance().uid //?: ""
        val ref = FirebaseDatabase.getInstance().getReference("/User/$uid")

        val user = User(uid, name, username, photoUrl)

        ref.setValue(user)
                .addOnSuccessListener {
                    Log.d(TAG, "data berhasil disimpan ke database")
                }

    }
}
