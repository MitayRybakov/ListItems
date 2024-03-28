package com.example.mylist.presentation.ui.mainScreen.fragments.productAdd

import androidx.lifecycle.ViewModel
import com.example.mylist.MyListAPP
import com.example.mylist.domain.model.Item
import com.example.mylist.domain.usecase.AddProductUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductAddViewModel : ViewModel() {

    private val addProductUseCase = AddProductUseCase(MyListAPP.instance.repository)

    private val _uiState = MutableStateFlow(
        AddProductState(
            name = "",
            price = ""
        )
    )
    val uiState: StateFlow<AddProductState> = _uiState.asStateFlow()

    fun addProduct(item: Item) {
        addProductUseCase(item)
    }

    fun onNameChanged(name: String) {
        _uiState.value = _uiState.value.copy(name = name)
    }

    fun onPriceChanged(price: String) {
        _uiState.value = _uiState.value.copy(price = price)
    }
}