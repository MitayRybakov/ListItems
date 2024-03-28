package com.example.mylist

import android.app.Application
import android.util.Log
import com.example.mylist.data.repository.ItemListRepository

class MyListAPP : Application() {

    lateinit var repository: ItemListRepository

    override fun onCreate() {
        super.onCreate()
        instance = this
        repository = ItemListRepository()
    }

    companion object {
         lateinit var instance: MyListAPP
             private set
    }
}