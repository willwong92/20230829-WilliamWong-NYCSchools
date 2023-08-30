package com.example.a20230829_williamwong_nycschools.presentation.home.state

import com.example.a20230829_williamwong_nycschools.domain.school.model.School

/**
 * @author by William Wong on 08/29/2023
 */
data class HomeUiState(
    val schools: List<School> = emptyList(),
    val showLoading: Boolean = true,
    val errorMessage: String? = null
)