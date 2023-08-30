package com.example.a20230829_williamwong_nycschools.presentation.detail.state

/**
 * @author by William Wong on 08/29/2023
 */
data class SchoolSatDetailUiState(
    val schoolName: String = "",
    val testTakers: String = "",
    val criticalReadingAvgScore: String = "",
    val mathAvgScore: String = "",
    val writingAvgScore: String = "",
)