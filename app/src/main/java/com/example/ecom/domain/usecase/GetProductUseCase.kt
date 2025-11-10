package com.example.ecom.domain.usecase

import com.example.ecom.domain.model.Product
import com.example.ecom.domain.repository.ProductRepository
import javax.inject.Inject

class GetProductUseCase @Inject constructor(
    val repository: ProductRepository,
) {

    suspend operator fun invoke(id: Int): Result<Product> = repository.getProduct(id)

}