package com.example.mylist

import android.app.Application
import com.example.mylist.data.repository.ItemListRepository

class MyListAPP : Application(){

    private  var repository = ItemListRepository()

    override fun onCreate() {
        super.onCreate()
    }



    companion object {
         var repo = ItemListRepository()
            private set
    }
}