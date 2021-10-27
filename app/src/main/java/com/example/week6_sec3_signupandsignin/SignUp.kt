package com.example.week6_sec3_signupandsignin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        var dbhpr = MyDBHelper(applicationContext)

        submit_btn.setOnClickListener {
            var name = name_ED.text.toString().lowercase()
            var location = location_ED.text.toString().lowercase()
            var mobile = mobile_ED.text.toString()
            var password = psw_ED.text.toString()
            if(name.isNotEmpty() && location.isNotEmpty() && mobile.isNotEmpty() && password.isNotEmpty() ) {

                dbhpr.save_DB(name, location, mobile, password)
                Toast.makeText(applicationContext, "data saved successfully!  ", Toast.LENGTH_SHORT)
                    .show()
            }
            else{
                Toast.makeText(applicationContext, "Please Enter All  ", Toast.LENGTH_SHORT).show()

            }
            val intent = Intent(this, Details::class.java)
            intent.putExtra("sendMobile", mobile)
            startActivity(intent)

        }
    }
}