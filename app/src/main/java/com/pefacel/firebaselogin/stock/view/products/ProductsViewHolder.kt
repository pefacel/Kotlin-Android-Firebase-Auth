package com.pefacel.firebaselogin.stock.view.products

import androidx.recyclerview.widget.RecyclerView
import com.pefacel.firebaselogin.databinding.ItemProductsBinding
import com.pefacel.firebaselogin.stock.data.ProductModel

class ProductsViewHolder(private val binding: ItemProductsBinding) :
    RecyclerView.ViewHolder(binding.root) {


    fun render(product: ProductModel) {
        binding.textViewName.text = product.title

    }
}