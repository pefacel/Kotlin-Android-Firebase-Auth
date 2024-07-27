package com.pefacel.firebaselogin.stock.view.stock

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.pefacel.firebaselogin.R
import com.pefacel.firebaselogin.databinding.ActivityLoginBinding
import com.pefacel.firebaselogin.databinding.ActivityStockBinding
import com.pefacel.firebaselogin.stock.view.products.ProductsFragment

class StockActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStockBinding


    private val productsFragment = ProductsFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStockBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initUI()
    }

    private fun initUI() {
        setCurrentFragment(productsFragment)
    }

    private fun setCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frameLayoutFragment, fragment)
            commit()
        }
    }


}