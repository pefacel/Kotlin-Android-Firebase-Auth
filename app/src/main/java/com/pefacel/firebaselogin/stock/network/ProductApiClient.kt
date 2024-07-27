package com.pefacel.firebaselogin.stock.network

import com.pefacel.firebaselogin.stock.data.ProductModel
import retrofit2.Response
import retrofit2.http.GET

interface ProductApiClient {
    @GET("products")
    suspend fun getProducts(): Response<List<ProductModel>>
}


