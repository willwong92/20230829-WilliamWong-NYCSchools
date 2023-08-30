package com.example.a20230829_williamwong_nycschools.domain.sat.model

import com.google.gson.annotations.SerializedName

/**
 * @author by William Wong on 08/29/2023
 */
data class SatResult (
    val id: String,
    val schoolName: String,
    val testTakers: String,
    val criticalReadingAvgScore: String,
    val mathAvgScore: String,
    val writingAvgScore: String,
)