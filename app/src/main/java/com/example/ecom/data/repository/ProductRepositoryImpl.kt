package com.example.ecom.data.repository

import com.example.ecom.core.utils.toProduct
import com.example.ecom.data.remote.ApiService
import com.example.ecom.domain.model.Product
import com.example.ecom.domain.repository.ProductRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ProductRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ProductRepository{

    override suspend fun getProducts(): Result<List<Product>> {
        return try{
            val products = apiService.getProducts().map { dto ->
                toProduct(dto)
            }

            Result.success(products)
        }catch(e: Exception){
            Result.failure(e)
        }
    }

    override suspend fun getProduct(id: Int): Result<Product> {
        return try{
            val productDto = apiService.getProduct(id)
            Result.success(toProduct(productDto = productDto))
        }catch(e: Exception){
            Result.failure(e)
        }
    }


}