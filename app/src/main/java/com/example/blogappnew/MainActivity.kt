package com.example.blogappnew

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
            isFirstTime()
        }, 3000)
    }

    private fun isFirstTime() {
        val preference = application.getSharedPreferences("onBoard", Context.MODE_PRIVATE)
        val isFirstTime = preference.getBoolean("isFirstTime", true)
        // default value true
        if (isFirstTime) {
            // if its true then its first time and we will change it to false
            val editor = preference.edit()
            editor.putBoolean("isFirstTime", false)
            editor.apply()

            // start onBoard activity
            startActivity(Intent(this, OnBoardActivity::class.java))
            finish()
        } else {
            // start Auth activity
            startActivity(Intent(this, AuthActivity::class.java))
            finish()
        }
    }
}