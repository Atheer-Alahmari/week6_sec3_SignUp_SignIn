package com.example.week6_sec3_signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_details.*

class Details : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

//        val sendName=intent.getStringExtra("sendName")
//        val sendL=intent.getStringExtra("sendLocation")
//        val sendM=intent.getStringExtra("sendMobile")
//        welcMobile_TV.text =" Welcome  ${sendM.toString()}"
//        nameD_TV.text=sendName
//        locationD_TV.text=sendL

       val sendM=intent.getStringExtra("sendMobile")
        welcMobile_TV.text=" Welcome  $sendM"
        println(sendM)


        var dbhpr=MyDBHelper(applicationContext)
        var info_user = dbhpr.retrive(sendM!!)

        nameD_TV.text=info_user.name
        locationD_TV.text=info_user.location

        signOut_btn.setOnClickListener {
            var intent= Intent(applicationContext,MainActivity::class.java)
            startActivity(intent)
        }
    }
}