package com.example.a20230829_williamwong_nycschools.data.repository

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.domain.model.School
import com.example.a20230829_williamwong_nycschools.domain.repository.SchoolRepository

/**
 * @author by William Wong on 08/29/2023
 */
class SchoolRepositoryImpl(
    private val remote: SchoolDataSource.Remote
) : SchoolRepository {
    override suspend fun getSchools(): Result<List<School>> {
        return remote.getSchools()
    }
}