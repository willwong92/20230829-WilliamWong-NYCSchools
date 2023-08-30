package com.example.a20230829_williamwong_nycschools.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a20230829_williamwong_nycschools.domain.usecase.GetSchools
import com.example.a20230829_williamwong_nycschools.domain.util.onError
import com.example.a20230829_williamwong_nycschools.domain.util.onSuccess
import com.example.a20230829_williamwong_nycschools.presentation.home.state.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by William Wong on 08/29/2023
 */
@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSchools: GetSchools,
) : ViewModel() {

    private val _uiState: MutableStateFlow<HomeUiState> = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        viewModelScope.launch {
            loadSchools()
        }
    }

    private suspend fun loadSchools() {
        getSchools.invoke()
            .onSuccess { schools ->
                _uiState.update {
                    it.copy(
                        schools = schools,
                        showLoading = false,
                        errorMessage = null
                    )
                }
            }.onError { error ->
                _uiState.update { it.copy(showLoading = false, errorMessage = error.message) }
            }
    }
}