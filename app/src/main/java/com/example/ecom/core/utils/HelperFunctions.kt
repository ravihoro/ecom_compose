package com.example.ecom.core.utils

import com.example.ecom.data.remote.ProductDto
import com.example.ecom.domain.model.Product
import java.text.DecimalFormat

fun Double.toPriceString(): String {
    val formatter = DecimalFormat("#,##0.00")
    return formatter.format(this)
}

fun toProduct(productDto: ProductDto): Product {
    return Product(
        id = productDto.id,
        title = productDto.title,
        price = productDto.price,
        description = productDto.description,
        category = productDto.category,
        imageUrl = productDto.imageUrl,
    )
}