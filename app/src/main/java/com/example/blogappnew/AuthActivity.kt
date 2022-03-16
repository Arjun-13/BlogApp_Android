package com.example.blogappnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.blogappnew.databinding.ActivityAuthBinding
import com.example.blogappnew.fragments.SignInFragment

class AuthActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAuthBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAuthBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    private fun initViews() {
        supportFragmentManager.beginTransaction().replace(R.id.frame_auth_container, SignInFragment()).commit()
    }
}