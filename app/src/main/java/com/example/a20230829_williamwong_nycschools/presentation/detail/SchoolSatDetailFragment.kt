package com.example.a20230829_williamwong_nycschools.presentation.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.a20230829_williamwong_nycschools.databinding.FragmentSchoolSatDetailBinding
import com.example.a20230829_williamwong_nycschools.presentation.base.BaseFragment
import com.example.a20230829_williamwong_nycschools.presentation.detail.state.SchoolSatDetailUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * @author by William Wong on 08/29/2023
 */
@AndroidEntryPoint
class SchoolSatDetailFragment : BaseFragment<FragmentSchoolSatDetailBinding>() {

    val viewModel: SchoolSatDetailViewModel by viewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSchoolSatDetailBinding = FragmentSchoolSatDetailBinding.inflate(inflater)

    private val args: SchoolSatDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launchWhenStarted {
            viewModel.getSchoolSatDetail(args.schoolSatDetailId)
        }
        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                launch { uiState.collect { handleSchoolSatDetailsUiState(it) } }
            }
        }
    }

    private fun handleSchoolSatDetailsUiState(schoolState: SchoolSatDetailUiState) {

    }
}