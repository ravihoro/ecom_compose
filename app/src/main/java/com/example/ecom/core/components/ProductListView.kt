package com.example.ecom.core.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.ecom.domain.model.Product

@Composable
fun ProductListView(
    products: List<Product>
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        contentPadding  = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.fillMaxSize(),
    ) {
        items(
            count = products.size,
            key = { products[it].title },
        ){ idx ->
            ProductCard(
                product = products[idx]
            )
        }
    }
}