package com.pefacel.firebaselogin.auth.view.register

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.pefacel.firebaselogin.R
import com.pefacel.firebaselogin.auth.view.AuthViewModel
import com.pefacel.firebaselogin.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    private val authViewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        authViewModel.registerWithEmailAndPassword(
            "cmagrop@gmail.com",
            "euclides1234"
        )
    }
}