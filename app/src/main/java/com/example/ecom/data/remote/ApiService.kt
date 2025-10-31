package com.example.ecom.data.remote

import retrofit2.http.GET

interface ApiService {

    @GET("/products")
    suspend fun getProducts(): List<ProductDto>

}