package com.example.week6_sec3_signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_details.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_in.*

class SignIn : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        signININ_btn.setOnClickListener {
            var mobile = mobileIN_ED.text.toString()
            var password = pswIN_ED.text.toString()

            var dbhpr = MyDBHelper(applicationContext)
            if (mobile.isNotEmpty() && password.isNotEmpty()) {

                var info_user = dbhpr.retrive(mobile)

                if (password == info_user.password) {
                    val intent = Intent(this, Details::class.java)
                    intent.putExtra("sendMobile", mobile)
                    startActivity(intent)
                    println(mobile)

                } else {
                    Toast.makeText(applicationContext, "Your Entry Wrong", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(applicationContext, "Please Enter All  ", Toast.LENGTH_SHORT).show()

            }
        }
    }
}