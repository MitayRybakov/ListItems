package com.example.mylist.presentation.ui.mainScreen.fragments.list

sealed interface ItemListCommand {

    data object OpenAddProductScreen : ItemListCommand
}