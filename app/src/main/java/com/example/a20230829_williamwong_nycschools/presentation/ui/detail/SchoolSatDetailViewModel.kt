package com.example.a20230829_williamwong_nycschools.presentation.ui.detail

import androidx.lifecycle.ViewModel
import com.example.a20230829_williamwong_nycschools.domain.sat.usecase.GetSatResults
import com.example.a20230829_williamwong_nycschools.domain.util.onError
import com.example.a20230829_williamwong_nycschools.domain.util.onSuccess
import com.example.a20230829_williamwong_nycschools.presentation.ui.detail.state.SchoolSatDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * @author by William Wong on 08/29/2023
 */
@HiltViewModel
class SchoolSatDetailViewModel @Inject constructor(
    private val getSatResults: GetSatResults
): ViewModel() {

    private val _uiState: MutableStateFlow<SchoolSatDetailUiState> = MutableStateFlow(
        SchoolSatDetailUiState()
    )
    val uiState = _uiState.asStateFlow()

    suspend fun getSchoolSatDetail(schoolId: String) {
        getSatResults.invoke(schoolId).onSuccess { result ->
            _uiState.update {
                it.copy(
                    showLoading = false,
                    errorMessage = null,
                    schoolName = result.schoolName,
                    criticalReadingAvgScore = result.criticalReadingAvgScore,
                    mathAvgScore = result.mathAvgScore,
                    testTakers = result.testTakers,
                    writingAvgScore = result.writingAvgScore
                )
            }
        }.onError { error ->
            _uiState.update { it.copy(showLoading = false, errorMessage = error.message) }
        }
    }

}