package com.example.ecom.presentation.ui.product_detail

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecom.presentation.viewmodel.ProductDetailState
import com.example.ecom.presentation.viewmodel.ProductViewModel

@Composable
fun ProductDetailScreen(
    viewModel: ProductViewModel = hiltViewModel()
){
    val safeModifier = Modifier
        .fillMaxSize()
        .safeDrawingPadding()

    val state by viewModel.productDetailState.collectAsState()

    when(state){
        is ProductDetailState.Loading -> {
            Box(
                modifier = safeModifier,
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }

        is ProductDetailState.Error -> {
            Box(
                modifier = safeModifier,
                contentAlignment = Alignment.Center,
            ){
                Text("Error fetching product detail")
            }
        }

        is ProductDetailState.Success -> {
            Box(
                modifier = safeModifier,
                contentAlignment = Alignment.Center,
            ){
                Text("${(state as ProductDetailState.Success).product.id}")
            }

        }
    }
}