package com.tech4dev.tenantsapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler

class Splashscreen : AppCompatActivity() {
    lateinit var handler :Handler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)
        handler= Handler()
        handler.postDelayed(
            {
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            },4000
        )

    }
}