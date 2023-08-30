package com.example.a20230829_williamwong_nycschools.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a20230829_williamwong_nycschools.databinding.FragmentHomeBinding
import com.example.a20230829_williamwong_nycschools.presentation.base.BaseFragment
import com.example.a20230829_williamwong_nycschools.presentation.home.state.HomeUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * @author by William Wong on 08/29/2023
 */
@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    val viewModel: HomeViewModel by viewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        observeViewModel()
    }

    private fun initRecyclerView() {
        binding.schoolRv.apply {
            layoutManager = GridLayoutManager(activity, 2)
            adapter = SchoolAdapter()
            addItemDecoration(DividerItemDecoration(activity, LinearLayoutManager.VERTICAL))
        }
    }

    private fun observeViewModel() = with(viewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch {
                    uiState.collect {
                        handleHomeUiState(it)
                    }
                }
            }
        }
    }

    private fun handleHomeUiState(it: HomeUiState) {
        (binding.schoolRv.adapter as SchoolAdapter).submitList(it.schools)
        binding.progressBar.isVisible = it.showLoading
        if (it.errorMessage != null) Toast.makeText(requireActivity().applicationContext, it.errorMessage, Toast.LENGTH_LONG).show()
    }
}