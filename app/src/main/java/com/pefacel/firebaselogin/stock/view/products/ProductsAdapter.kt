package com.pefacel.firebaselogin.stock.view.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pefacel.firebaselogin.databinding.ItemProductsBinding
import com.pefacel.firebaselogin.stock.data.ProductModel

class ProductsAdapter(
    private var products: List<ProductModel>
) : RecyclerView.Adapter<ProductsViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val binding =
            ItemProductsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ProductsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        products.size
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        holder.render(products.get(position))
    }
}