package com.example.mylist.presentation.ui.mainScreen

import androidx.lifecycle.ViewModel
import com.example.mylist.MyListAPP
import com.example.mylist.domain.usecase.GetItemListUseCase
import com.example.mylist.domain.usecase.LoadItemListUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
     private val getItemListUseCase = GetItemListUseCase(MyListAPP.repo)
     private val loadItemListUseCase = LoadItemListUseCase(MyListAPP.repo)

    private val _uiState = MutableStateFlow<ScreenState>(ScreenState.Start)
    val uiState: StateFlow<ScreenState> = _uiState.asStateFlow()

    fun setStartState() {
        _uiState.value = ScreenState.Start
    }

    fun setCatState() {
        _uiState.value = ScreenState.Cat
    }

    fun setListInfoState() {
        _uiState.value = ScreenState.List
          getItemListUseCase()
    }

    fun setAddState() {
        _uiState.value = ScreenState.Add
    }

    fun generateItemList() {
         loadItemListUseCase()
    }
}