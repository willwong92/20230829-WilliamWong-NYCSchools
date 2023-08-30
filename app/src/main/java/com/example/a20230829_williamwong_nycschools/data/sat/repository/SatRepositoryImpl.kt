package com.example.a20230829_williamwong_nycschools.data.sat.repository

import com.example.a20230829_williamwong_nycschools.data.school.repository.SchoolDataSource
import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.sat.repository.SatRepository
import com.example.a20230829_williamwong_nycschools.domain.school.model.School
import com.example.a20230829_williamwong_nycschools.domain.school.repository.SchoolRepository
import com.example.a20230829_williamwong_nycschools.domain.util.Result

class SatRepositoryImpl(
    private val remote: SatDataSource.Remote
) : SatRepository {
    override suspend fun getSatResults(schoolId: String): Result<SatResult> {
        return remote.getSatResults(schoolId)
    }
}