package com.example.mylist.presentation.ui.mainScreen.fragments.list

import com.example.mylist.domain.model.Item

sealed interface ItemListState {

    data object Initial : ItemListState
    data object Empty : ItemListState
    data class Full(val items: List<Item>) : ItemListState
}