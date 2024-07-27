package com.pefacel.firebaselogin.stock.network

import com.pefacel.firebaselogin.stock.data.ProductModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ProductService {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder().baseUrl("https://fakestoreapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build()
    }

    suspend fun getProducts(): List<ProductModel> {
        return withContext(Dispatchers.IO) {
            val response = getRetrofit().create(ProductApiClient::class.java).getProducts()
            println("response")
            println(response)
            response.body() ?: emptyList()
        }
    }
}