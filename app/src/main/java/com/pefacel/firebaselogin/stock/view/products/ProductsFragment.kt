package com.pefacel.firebaselogin.stock.view.products

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.pefacel.firebaselogin.databinding.FragmentProductsBinding
import com.pefacel.firebaselogin.stock.view.stock.StockViewModel
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager


class ProductsFragment : Fragment() {

    private lateinit var binding: FragmentProductsBinding

    private val stockViewModel: StockViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductsBinding.inflate(layoutInflater)

        initUI()

        return binding.root
    }

    private fun initUI() {

        stockViewModel.products.observe(viewLifecycleOwner, Observer { products ->
            binding.recyclerView.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            binding.recyclerView.adapter = ProductsAdapter(products)
        })

        stockViewModel.getProducts()
    }

}