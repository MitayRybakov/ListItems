package com.example.mylist.domain.usecase

import com.example.mylist.data.repository.ItemListRepository
import com.example.mylist.domain.model.Item
import kotlinx.coroutines.flow.StateFlow

class GetProductsUseCase(
    private val repository: ItemListRepository,
) {
    operator fun invoke() : StateFlow<ArrayList<Item>> = repository.getFlow()
}