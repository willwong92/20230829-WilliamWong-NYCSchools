package com.example.a20230829_williamwong_nycschools.data.sat.repository

import com.example.a20230829_williamwong_nycschools.data.sat.api.SatApiService
import com.example.a20230829_williamwong_nycschools.data.sat.mapper.toDomain
import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.util.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class SatRemoteDataSource(
    private val satApiService: SatApiService,
    private val coroutineDispatcher: CoroutineDispatcher
) : SatDataSource.Remote {
    override suspend fun getSatResults(schoolId: String): Result<SatResult> = withContext(coroutineDispatcher) {
        return@withContext try {
            val result = satApiService.getSatScores(schoolId)
            Result.Success(result.toDomain())
        } catch (e: Exception) {
            Result.Error(e)
        }
    }
}