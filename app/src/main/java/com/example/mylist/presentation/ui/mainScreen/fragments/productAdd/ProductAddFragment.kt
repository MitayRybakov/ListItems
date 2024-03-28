package com.example.mylist.presentation.ui.mainScreen.fragments.productAdd

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.mylist.domain.model.Item
import com.example.mylist.presentation.ui.mainScreen.fragments.products.ProductsFragment
import com.example.mylist.util.openFragment

class ProductAddFragment : Fragment() {
    private val viewModel = ProductAddViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireContext()).apply {
            setContent {
                val state by viewModel.uiState.collectAsState()
                val text = state.name
                val price = state.price
                val newItem = Item(text, price)

                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    TextField(
                        value = text,
                        onValueChange = { newText -> viewModel.onNameChanged(newText) },
                        label = { Text("Название продукта ") },
                        placeholder = { Text("Введите название  продукта ") }
                    )
                    TextField(
                        value = price,
                        onValueChange = { newPrice -> viewModel.onPriceChanged(newPrice) },
                        label = { Text("Цена продукта ") },
                        placeholder = { Text("Введите цену  продукта ") },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }

                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Row(
                        modifier = Modifier
                            .padding(horizontal = 10.dp)
                    ) {
                        Button(
                            onClick = {
                                viewModel.addProduct(newItem)
                                requireActivity().openFragment(ProductsFragment())
                            },
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .size(height = 100.dp, width = 190.dp)
                        ) {
                            Text(
                                text = "Сохранить",
                                modifier = Modifier
                                    .padding(all = 10.dp),
                                fontSize = 22.sp
                            )
                        }
                        Button(
                            onClick = {
                                requireActivity().openFragment(ProductsFragment())
                            },
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .size(height = 100.dp, width = 190.dp)
                        ) {
                            Text(
                                text = "Назад",
                                modifier = Modifier
                                    .padding(all = 10.dp),
                                fontSize = 22.sp
                            )
                        }
                    }
                }
            }
        }
}