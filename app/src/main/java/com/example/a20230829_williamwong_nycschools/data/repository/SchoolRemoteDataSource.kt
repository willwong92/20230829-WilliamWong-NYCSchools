package com.example.a20230829_williamwong_nycschools.data.repository

import com.example.a20230829_williamwong_nycschools.data.SchoolApiService
import com.example.a20230829_williamwong_nycschools.domain.model.School
import kotlinx.coroutines.CoroutineDispatcher

/**
 * @author by William Wong on 08/29/2023
 */
class SchoolRemoteDataSource (
    private val schoolApiService: SchoolApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SchoolDataSource.Remote {
    override suspend fun getSchools(): List<School> {
        TODO("Not yet implemented")
    }
}