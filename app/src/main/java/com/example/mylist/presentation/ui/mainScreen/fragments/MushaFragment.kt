package com.example.mylist.presentation.ui.mainScreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mylist.R
import com.example.mylist.databinding.FragmentMushaBinding
import com.example.mylist.databinding.FragmentStartBinding
import com.example.mylist.util.openFragment

class MushaFragment : Fragment() {

    private lateinit var binding: FragmentMushaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMushaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backButton.setOnClickListener {
            requireActivity().openFragment(StartFragment())
        }
    }
}