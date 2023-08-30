package com.example.a20230829_williamwong_nycschools.domain.repository

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.domain.model.School

/**
 * @author by William Wong on 08/18/2023
 */
interface SchoolRepository {
    suspend fun getSchools(): Result<List<School>>
}