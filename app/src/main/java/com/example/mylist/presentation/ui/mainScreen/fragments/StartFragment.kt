package com.example.mylist.presentation.ui.mainScreen.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mylist.databinding.FragmentStartBinding
import com.example.mylist.presentation.ui.mainScreen.fragments.list.ItemListFragment
import com.example.mylist.util.openFragment

class StartFragment : Fragment() {

    private lateinit var binding: FragmentStartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentStartBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.openMishaButton.setOnClickListener {
            requireActivity().openFragment(MushaFragment())
        }

        binding.openCartButton.setOnClickListener {
            requireActivity().openFragment(ItemListFragment())
        }
    }
}