package com.example.a20230829_williamwong_nycschools.data.repository

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.data.SchoolApiService
import com.example.a20230829_williamwong_nycschools.data.`package`.toDomain
import com.example.a20230829_williamwong_nycschools.domain.model.School
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

/**
 * @author by William Wong on 08/29/2023
 */
class SchoolRemoteDataSource (
    private val schoolApiService: SchoolApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SchoolDataSource.Remote {
    override suspend fun getSchools(): Result<List<School>> = withContext(coroutineDispatcher) {
        return@withContext try {
            val result = schoolApiService.getSchools()
            Result.Success(result.map { it.toDomain() })
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}