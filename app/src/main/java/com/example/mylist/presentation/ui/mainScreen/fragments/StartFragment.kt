package com.example.mylist.presentation.ui.mainScreen.fragments

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
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.mylist.presentation.ui.mainScreen.fragments.products.ProductsFragment
import com.example.mylist.util.openFragment

class StartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireContext()).apply {
            setContent {
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
                                requireActivity().openFragment(MushaFragment())
                            },
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                                .size(height = 100.dp, width = 190.dp)
                        ) {
                            Text(
                                text = "Мышабура",
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
                                text = "Открыть список",
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