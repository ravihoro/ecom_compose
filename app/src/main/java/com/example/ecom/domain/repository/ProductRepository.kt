package com.example.ecom.domain.repository

import com.example.ecom.domain.model.Product

interface ProductRepository {

    suspend fun getProducts() : Result<List<Product>>

}