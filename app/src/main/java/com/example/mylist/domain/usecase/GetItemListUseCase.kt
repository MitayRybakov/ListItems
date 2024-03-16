package com.example.mylist.domain.usecase

import com.example.mylist.data.repository.ItemListRepository
import com.example.mylist.domain.model.Item
import kotlinx.coroutines.flow.MutableStateFlow

internal class GetItemListUseCase(
    private val repository: ItemListRepository,
) {

    operator fun invoke(): MutableStateFlow<ArrayList<Item>> =
        repository.getFlow()
}