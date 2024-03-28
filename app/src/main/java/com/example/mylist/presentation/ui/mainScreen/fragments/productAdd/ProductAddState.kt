package com.example.mylist.presentation.ui.mainScreen.fragments.productAdd


data class AddProductState(
        val name: String,
        val price: String,
        val error: ErrorProductCreation? = null
    )

    sealed interface ErrorProductCreation {
        data object NameError : ErrorProductCreation
        data object PriceError : ErrorProductCreation
    }
