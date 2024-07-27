package com.pefacel.firebaselogin.auth.view.login

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.pefacel.firebaselogin.R
import com.pefacel.firebaselogin.auth.view.AuthViewModel
import com.pefacel.firebaselogin.auth.view.register.RegisterActivity
import com.pefacel.firebaselogin.databinding.ActivityLoginBinding
import com.pefacel.firebaselogin.stock.view.stock.StockActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val authViewModel: AuthViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
//        setContentView(binding.root)

        startActivity(Intent(this, StockActivity::class.java))

//        initUI()

    }

    private fun initUI() {

        authViewModel.isLoading.observe(this, Observer { isLoading ->
            binding.progressBar.isVisible = isLoading

        })

        binding.buttonRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        binding.buttonLogin.setOnClickListener {

            authViewModel.loginWithEmailAndPassword(
                binding.editTextEmail.text.toString(),
                binding.editTextPassword.text.toString()
            )


        }




        authViewModel.user.observe(this, Observer { user ->

            if (user != null) {
                startActivity(Intent(this, StockActivity::class.java))
            }


        })


    }
}