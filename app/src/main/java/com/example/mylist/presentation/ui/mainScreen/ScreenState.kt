package com.example.mylist.presentation.ui.mainScreen

sealed class ScreenState {
    data object Start : ScreenState()
    data object Cat : ScreenState()
    data object List : ScreenState()
    data object Add : ScreenState()
}