package com.example.mylist.presentation.ui.mainScreen

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.mylist.R
import com.example.mylist.domain.model.Item

class ListItemAdapter(context: Context, resource: Int, itemList: List<Item>) :
    ArrayAdapter<Item>(context, resource, itemList) {
    private val list = itemList

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        val inflater: LayoutInflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = inflater.inflate(R.layout.list, parent, false)
        val name = view.findViewById<TextView>(R.id.name)
        name.text = list[position].names
        val price = view.findViewById<TextView>(R.id.price)
        price.text = list[position].prices
        return view
    }
}