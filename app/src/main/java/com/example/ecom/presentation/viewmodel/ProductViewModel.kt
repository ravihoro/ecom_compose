package com.example.ecom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecom.domain.model.Product
import com.example.ecom.domain.usecase.GetProductUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface ProductDetailState {
    object Loading: ProductDetailState

    data class Success(val product: Product): ProductDetailState

    data class Error(val message: String): ProductDetailState
}

class ProductViewModel @Inject constructor(
    private val useCase: GetProductUseCase,
    @Assisted private val productId: Int,
) : ViewModel() {

    private val _productDetailState = MutableStateFlow<ProductDetailState>(ProductDetailState.Loading)

    val productDetailState: StateFlow<ProductDetailState> = _productDetailState

    init {
        fetchProduct(productId)
    }

    fun fetchProduct(productId: Int){
        viewModelScope.launch {
            _productDetailState.value = ProductDetailState.Loading

            val result = useCase(productId)

            result.onSuccess { product ->
                _productDetailState.value = ProductDetailState.Success(product = product)
            }.onFailure {
                _productDetailState.value = ProductDetailState.Error("Failed to get product")
            }
        }
    }

}