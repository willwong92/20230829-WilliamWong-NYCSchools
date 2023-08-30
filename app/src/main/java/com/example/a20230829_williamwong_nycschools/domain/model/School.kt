package com.example.a20230829_williamwong_nycschools.domain.model

/**
 * @author by William Wong on 08/29/2023
 */
data class School (
    val id: String,
    val schoolName: String,
    val location: String,
    val city: String,
    val zipCode: String
)