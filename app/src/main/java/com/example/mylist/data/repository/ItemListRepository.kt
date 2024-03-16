package com.example.mylist.data.repository

import com.example.mylist.domain.model.Item
import kotlinx.coroutines.flow.MutableStateFlow

class ItemListRepository {
    private val itemListFlow = MutableStateFlow<ArrayList<Item>>(ArrayList<Item>())

    fun getFlow(): MutableStateFlow<ArrayList<Item>> = itemListFlow

    fun load() {
        if (itemListFlow.value.isEmpty()) {
            itemListFlow.value.add(Item("First", "100"))
            itemListFlow.value.add(Item("Second", "200"))
            itemListFlow.value.add(Item("Third", "300"))
            itemListFlow.value.add(Item("Fourth", "400"))
            itemListFlow.value.add(Item("Fifth", "500"))
        }
    }
}