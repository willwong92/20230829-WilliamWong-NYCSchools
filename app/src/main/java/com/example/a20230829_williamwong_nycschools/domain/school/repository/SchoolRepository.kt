package com.example.a20230829_williamwong_nycschools.domain.school.repository

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.domain.school.model.School

/**
 * @author by William Wong on 08/29/2023
 */
interface SchoolRepository {
    suspend fun getSchools(): Result<List<School>>
}