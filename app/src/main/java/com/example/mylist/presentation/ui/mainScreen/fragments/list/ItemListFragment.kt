package com.example.mylist.presentation.ui.mainScreen.fragments.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.mylist.presentation.ui.mainScreen.fragments.ItemAddFragment
import com.example.mylist.R
import com.example.mylist.databinding.FragmentListBinding
import com.example.mylist.presentation.ui.mainScreen.ListItemAdapter
import com.example.mylist.util.openFragment
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class ItemListFragment : Fragment() {

    private lateinit var viewModel: ItemListViewModel
    private lateinit var binding: FragmentListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = ItemListViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(layoutInflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.uiState.onEach { state ->
            when (state) {
                is ItemListState.Initial -> {
                    binding.text.isVisible = false
                    binding.listView.isVisible = false
                }

                is ItemListState.Empty -> {
                    binding.listView.isVisible = false
                    binding.text.isVisible = true
                    binding.text.text = getString(R.string.empty_items_message)
                }

                is ItemListState.Full -> {
                    binding.text.isVisible = false
                    binding.listView.isVisible = true

                    val adapter = ListItemAdapter(
                        requireContext(),
                        R.layout.list,
                        state.items
                    )
                    binding.listView.adapter = adapter
                }
            }
        }.launchIn(viewLifecycleOwner.lifecycleScope)

        viewModel.command.onEach { command ->
            when (command) {
                is ItemListCommand.OpenAddProductScreen -> {
                    requireActivity().openFragment(ItemAddFragment())
                }
            }

        }.launchIn(viewLifecycleOwner.lifecycleScope)

        binding.addProductButton.setOnClickListener {
            viewModel.openAddProductScreen()
        }
    }
}