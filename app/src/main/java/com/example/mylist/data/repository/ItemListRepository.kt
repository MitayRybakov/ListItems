package com.example.mylist.data.repository

import com.example.mylist.domain.model.Item
import kotlinx.coroutines.flow.MutableStateFlow

class ItemListRepository {

    private val itemListFlow = MutableStateFlow(arrayListOf<Item>())

    fun getFlow(): MutableStateFlow<ArrayList<Item>> =
        itemListFlow

    fun load() {
        if (itemListFlow.value.isEmpty()) {
            val items = getInitialItems()
            itemListFlow.value.addAll(items)
        }
    }

    private fun getInitialItems(): List<Item> =
        mutableListOf(
            Item("First", "100"),
            Item("Second", "200"),
            Item("Third", "300"),
            Item("Fourth", "400"),
            Item("Fifth", "500"),
        )
    fun addItem(item: Item){
        itemListFlow.value.add(item)
    }
}