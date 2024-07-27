package com.pefacel.firebaselogin.stock.view.stock

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.pefacel.firebaselogin.databinding.ActivityLoginBinding

class StockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val stockViewModel: StockViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        stockViewModel.products.observe(this, Observer { products ->
            println(products)
        })
    }
}