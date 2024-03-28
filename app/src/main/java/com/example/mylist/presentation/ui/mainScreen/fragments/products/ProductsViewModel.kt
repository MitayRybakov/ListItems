package com.example.mylist.presentation.ui.mainScreen.fragments.products

import androidx.lifecycle.ViewModel
import com.example.mylist.MyListAPP
import com.example.mylist.domain.usecase.GetProductsUseCase
import com.example.mylist.domain.usecase.LoadProductsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductsViewModel : ViewModel() {

    private val getProductsUseCase = GetProductsUseCase(MyListAPP.instance.repository)
    private val loadProductsUseCase = LoadProductsUseCase(MyListAPP.instance.repository)

    private val _uiState = MutableStateFlow(ProductsState(getProductsUseCase().value))
    val uiState: StateFlow<ProductsState> = _uiState.asStateFlow()

    fun generateProducts() {
        loadProductsUseCase()
    }
}
