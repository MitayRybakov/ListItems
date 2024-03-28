package com.example.mylist.domain.usecase

import com.example.mylist.data.repository.ItemListRepository
import com.example.mylist.domain.model.Item


class AddProductUseCase(private val repository: ItemListRepository) {
    operator fun invoke(item:Item) {
        repository.addItem(item)
    }
}