package com.example.a20230829_williamwong_nycschools.presentation.detail

import androidx.lifecycle.ViewModel
import com.example.a20230829_williamwong_nycschools.presentation.detail.state.SchoolSatDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author by William Wong on 08/29/2023
 */
@HiltViewModel
class SchoolSatDetailViewModel @Inject constructor(
    //private val getSchoolSatDetails: GetSchoolSatDetails
): ViewModel() {

    private val _uiState: MutableStateFlow<SchoolSatDetailUiState> = MutableStateFlow(SchoolSatDetailUiState())
    val uiState = _uiState.asStateFlow()

    suspend fun getSchoolSatDetail(schoolId: String) {
        /*getSchoolSatDetails.invoke(schoolId).onSuccess {
            _uiState.value = SchoolSatDetailUiState(
                schoolName = scho,
                hp = it.hp,
                level = it.level,
                types = it.types ?: emptyList(),
                image = it.images.large
            )
        }*/
    }

}