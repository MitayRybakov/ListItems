package com.example.mylist.presentation.ui.mainScreen

import android.os.Bundle
import android.view.View.inflate
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.mylist.MyListAPP
import com.example.mylist.R
import com.example.mylist.data.repository.ItemListRepository
import com.example.mylist.databinding.FragmentItemAddBinding
import com.example.mylist.databinding.FragmentListBinding
import com.example.mylist.databinding.FragmentMushaBinding
import com.example.mylist.databinding.FragmentStartBinding
import com.example.mylist.domain.model.Item


class MainActivity : AppCompatActivity() {

    private val viewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StartApp()
        }
    }

    @Composable
    private fun StartApp() {
        val state: ScreenState by viewModel.uiState.collectAsState()
        viewModel.generateItemList()

        when (state) {
            is ScreenState.Start -> {
                OpenStartFragment()
            }

            is ScreenState.Cat -> {
                OpenCatFragment()
            }

            is ScreenState.List -> {
                OpenListFragment()
            }

            is ScreenState.Add -> {
                OpenAddFragment()
            }
        }
    }

    @Composable
    private fun OpenStartFragment() {
        AndroidViewBinding(FragmentStartBinding::inflate) {
            button.setOnClickListener {
                viewModel.setCatState()
            }

            button2.setOnClickListener {
                viewModel.setListInfoState()
            }
        }
    }

    @Composable
    private fun OpenCatFragment() {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack("1")
            .commit()
        AndroidViewBinding(FragmentMushaBinding::inflate) {
            button3.setOnClickListener {
                viewModel.setStartState()
            }
        }
    }

    @Composable
    private fun OpenListFragment() {
        AndroidViewBinding(FragmentListBinding::inflate) {
            supportFragmentManager
                .beginTransaction()
                .addToBackStack("1")
                .commit()
            val itemList: List<Item> = MyListAPP
                .repo
                .getFlow()
                .value
            val adapter =
                ListItemAdapter(
                    this@MainActivity,
                    R.layout.list,
                    itemList
                )
            listView.adapter = adapter
            if (itemList.isEmpty()) {
                text.text = "List is Empty"
            }
            button4.setOnClickListener {
                viewModel.setAddState()
            }
        }
    }

    @Composable
    private fun OpenAddFragment() {
        AndroidViewBinding(FragmentItemAddBinding::inflate) {
               button5.setOnClickListener {
                   if (editTextText.text.isNotEmpty() && editTextText2.text.isNotEmpty()) {
                       val item2 = Item(editTextText.text.toString(), editTextText2.text.toString())
                       MyListAPP
                           .repo
                           .getFlow()
                           .value
                           .add(item2)
                       viewModel.setListInfoState()
                   } else {
                       Toast.makeText(this@MainActivity, "Заполните 2 поля", 3).show()
                   }

               }
            button6.setOnClickListener {
                viewModel.setListInfoState()
            }
        }
    }
}


