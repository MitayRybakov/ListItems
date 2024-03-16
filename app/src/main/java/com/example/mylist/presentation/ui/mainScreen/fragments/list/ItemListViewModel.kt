package com.example.mylist.presentation.ui.mainScreen.fragments.list

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

class ItemListViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<ItemListState>(ItemListState.Initial)
    val uiState: StateFlow<ItemListState> = _uiState.asStateFlow()

    private val _command = MutableSharedFlow<ItemListCommand>(
        replay = 0,
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST,
    )
    val command: SharedFlow<ItemListCommand> = _command.asSharedFlow()

    fun openAddProductScreen() {
        _command.tryEmit(ItemListCommand.OpenAddProductScreen)
    }
}