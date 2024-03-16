package com.example.mylist

import android.app.Application
import com.example.mylist.data.repository.ItemListRepository

class MyListAPP : Application() {

    lateinit var repository: ItemListRepository

    override fun onCreate() {
        super.onCreate()

        _instance = this
        repository = ItemListRepository()
    }

    companion object {

        private lateinit var _instance: MyListAPP

        val instance: MyListAPP
            get() = _instance
    }
}