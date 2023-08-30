package com.example.a20230829_williamwong_nycschools.data.dto

import com.google.gson.annotations.SerializedName

/**
 * @author by William Wong on 08/29/2023
 */
data class SchoolDto (
    @SerializedName("dbn")
    val id: String,
    @SerializedName("school_name")
    val schoolName: String,
    @SerializedName("location")
    val location: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("zip")
    val zipCode: String
)