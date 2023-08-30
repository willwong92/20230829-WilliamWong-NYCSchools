package com.example.a20230829_williamwong_nycschools.domain.sat.repository

import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.util.Result

/**
 * @author by William Wong on 08/29/2023
 */
interface SatRepository {
    suspend fun getSatResults(schoolId: String): Result<SatResult>
}