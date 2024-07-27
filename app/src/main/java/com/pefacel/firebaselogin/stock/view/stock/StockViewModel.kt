package com.pefacel.firebaselogin.stock.view.stock

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pefacel.firebaselogin.stock.data.ProductModel
import com.pefacel.firebaselogin.stock.network.ProductService
import kotlinx.coroutines.launch

class StockViewModel : ViewModel() {

    private var productService = ProductService()

    val products = MutableLiveData<List<ProductModel>>(emptyList())
    val isLoading = MutableLiveData<Boolean>(false)

    fun getProducts() {
        viewModelScope.launch {
            isLoading.postValue(true)

            val result = productService.getProducts()

            if (!result.isNullOrEmpty()) {
                products.postValue(result)
            }
            isLoading.postValue(false)

        }
    }


}