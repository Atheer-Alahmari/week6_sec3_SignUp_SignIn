package com.example.week6_sec3_signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        signIN_btn.setOnClickListener {
            var intent= Intent(applicationContext,SignIn::class.java)
            startActivity(intent)
        }

        signUP_btn.setOnClickListener {
            var intent= Intent(applicationContext,SignUp::class.java)
            startActivity(intent)
        }
    }
}