package com.example.ecom.presentation.ui.home

import android.widget.Space
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.navigation.NavController
import com.example.ecom.core.components.ProductListView
import com.example.ecom.core.components.SearchBar
import com.example.ecom.presentation.viewmodel.ProductListViewModel
import com.example.ecom.presentation.viewmodel.UiState

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: ProductListViewModel = hiltViewModel(),
) {

    val state by viewModel.uiState.collectAsState()

    val safeModifier = Modifier
        .fillMaxSize()
        .safeDrawingPadding()

    when(val s = state){
        is UiState.Loading -> Box(
            modifier = safeModifier,
            contentAlignment = Alignment.Center
        ){
            CircularProgressIndicator()
        }

        is UiState.Error -> {
            Box(
                modifier = safeModifier,
                contentAlignment = Alignment.Center
            ){
                Text(text = "Error: ${s.message}")
            }
        }

        is UiState.Success -> {
            Box(
                modifier = safeModifier,
                contentAlignment = Alignment.Center,
            ){
                Column {
                    SearchBar()
                    ProductListView(products = s.products, onProductClick = { productId ->
                        navController.navigate("product/$productId")
                    })
                }
            }
        }
    }
}