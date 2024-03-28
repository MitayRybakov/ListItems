package com.example.mylist.presentation.ui.mainScreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import com.example.mylist.R
import com.example.mylist.util.openFragment

class MushaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View =
        ComposeView(requireContext()).apply {
            setContent {
                Image(
                    painter = painterResource(id = R.drawable.photo_2024_03_09_12_52_45),
                    contentDescription = stringResource(id = R.string.Cat)
                )
                Column(
                    modifier = Modifier
                        .padding(horizontal = 10.dp)
                        .fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Button(
                        onClick = {
                            requireActivity().openFragment(StartFragment())
                        },
                        modifier = Modifier
                            .padding(vertical = 20.dp)
                            .fillMaxWidth(),
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