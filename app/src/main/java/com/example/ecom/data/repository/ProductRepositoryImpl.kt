package com.example.ecom.data.repository

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
                Product(
                    id = dto.id,
                    title = dto.title,
                    price = dto.price,
                    description = dto.description,
                    category = dto.category,
                    imageUrl = dto.imageUrl
                )
            }

            Result.success(products)
        }catch(e: Exception){
            Result.failure(e)
        }


    }

}