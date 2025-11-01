package com.example.ecom.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecom.domain.model.Product
import com.example.ecom.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface UiState {
    object Loading: UiState
    data class Success(val products: List<Product>) : UiState
    data class Error(val message: String): UiState
}

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val useCase: GetProductsUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)

    val uiState : StateFlow<UiState> = _uiState

    init {
        fetchProducts()
    }

    fun fetchProducts() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading

            val result = useCase();

            result.onSuccess {  products ->
                _uiState.value = UiState.Success(products)
            }.onFailure { e ->
                _uiState.value = UiState.Error(e.message ?: "Error")
            }

        }
    }

}