package com.example.a20230829_williamwong_nycschools.data.sat.dto

import com.google.gson.annotations.SerializedName

/**
 * @author by William Wong on 08/29/2023
 */
data class SatResultDto(
    @SerializedName("dbn")
    val id: String,
    @SerializedName("school_name")
    val schoolName: String,
    @SerializedName("num_of_sat_test_takers")
    val testTakers: String,
    @SerializedName("sat_critical_reading_avg_score")
    val criticalReadingAvgScore: String,
    @SerializedName("sat_math_avg_score")
    val mathAvgScore: String,
    @SerializedName("sat_writing_avg_score")
    val writingAvgScore: String,
)