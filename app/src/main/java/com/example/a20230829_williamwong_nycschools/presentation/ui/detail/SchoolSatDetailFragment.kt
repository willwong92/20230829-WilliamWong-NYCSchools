package com.example.a20230829_williamwong_nycschools.presentation.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.navArgs
import com.example.a20230829_williamwong_nycschools.databinding.FragmentSchoolSatDetailBinding
import com.example.a20230829_williamwong_nycschools.presentation.ui.base.BaseFragment
import com.example.a20230829_williamwong_nycschools.presentation.ui.detail.state.SchoolSatDetailUiState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

/**
 * @author by William Wong on 08/29/2023
 */
@AndroidEntryPoint
class SchoolSatDetailFragment : BaseFragment<FragmentSchoolSatDetailBinding>() {

    private val viewModel: SchoolSatDetailViewModel by viewModels()

    override fun inflateViewBinding(inflater: LayoutInflater): FragmentSchoolSatDetailBinding = FragmentSchoolSatDetailBinding.inflate(inflater)

    private val args: SchoolSatDetailFragmentArgs by navArgs()
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getSchoolSatDetail(args.schoolSatDetailId)
        }
        observeViewModel()
    }

    private fun observeViewModel() = with(viewModel) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                uiState.collect {
                    handleSchoolSatDetailsUiState(it)
                }
            }
        }
    }

    private fun handleSchoolSatDetailsUiState(schoolState: SchoolSatDetailUiState) {
        binding.progressBar.isVisible = schoolState.showLoading
        schoolState.errorMessage?.let { Toast.makeText(requireActivity().applicationContext, it, Toast.LENGTH_LONG).show() }
        binding.nameTv.text = schoolState.schoolName
        binding.testTakersTv.text = schoolState.testTakers
        binding.readingAvgTv.text = schoolState.criticalReadingAvgScore
        binding.mathAvgTv.text = schoolState.mathAvgScore
        binding.writingAvgTv.text = schoolState.writingAvgScore
    }
}