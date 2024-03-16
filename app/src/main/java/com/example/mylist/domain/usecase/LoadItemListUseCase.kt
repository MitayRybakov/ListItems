package com.example.mylist.domain.usecase

import com.example.mylist.data.repository.ItemListRepository

class LoadItemListUseCase(
    private val repository: ItemListRepository,
) {
    operator fun invoke() {
        repository.load()
    }
}