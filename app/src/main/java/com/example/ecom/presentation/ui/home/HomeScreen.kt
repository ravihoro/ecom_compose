package com.example.ecom.presentation.ui.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.ecom.core.components.ProductListView
import com.example.ecom.presentation.viewmodel.ProductListViewModel
import com.example.ecom.presentation.viewmodel.UiState

@Composable
fun HomeScreen(
    viewModel: ProductListViewModel = hiltViewModel()
) {

    val state by viewModel.uiState.collectAsState()

    when(val s = state){
        is UiState.Loading -> Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }

        is UiState.Error -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(text = "Error: ${s.message}")
            }
        }

        is UiState.Success -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center,
            ){
                ProductListView(products = s.products)
            }
        }
    }

}