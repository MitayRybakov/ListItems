package com.example.mylist.presentation.ui.mainScreen.fragments.products

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.mylist.presentation.ui.mainScreen.fragments.productAdd.ProductAddFragment
import com.example.mylist.util.openFragment

class ProductsFragment : Fragment() {

    private val viewModel = ProductsViewModel()

    @SuppressLint("StateFlowValueCalledInComposition")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireContext()).apply {
            setContent {
                val state by viewModel.uiState.collectAsState()
                viewModel.generateProducts()

                Box(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    contentAlignment = Alignment.Center,
                ) {
                    if (state.items.isNotEmpty()) {
                        LazyColumn(
                            modifier = Modifier
                                .background(Color.White),
                            content =
                            {
                                items(state.items.size) { index ->
                                    Row(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .fillMaxWidth(),
                                        horizontalArrangement = Arrangement.SpaceBetween
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .background(Color.Red)
                                                .fillMaxSize(0.5f)
                                        ) {
                                            Text(
                                                text = state.items[index].name,
                                                fontSize = 40.sp
                                            )
                                        }

                                        Box(
                                            modifier = Modifier
                                                .background(Color.Blue)
                                                .fillMaxSize(0.5f)
                                        ) {
                                            Text(
                                                text = state.items[index].price,
                                                fontSize = 40.sp,
                                            )
                                        }
                                    }
                                }
                            }
                        )
                    } else {
                        Text(
                            text = "Я пуст(((",
                            fontSize = 40.sp
                        )
                    }
                }
                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            requireActivity().openFragment(ProductAddFragment())
                        },
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .fillMaxWidth()
                    ) {
                        Text(
                            text = "Добавить  свой элемент",
                            modifier = Modifier
                                .padding(all = 10.dp),
                            fontSize = 22.sp
                        )
                    }
                }
            }
        }
}








