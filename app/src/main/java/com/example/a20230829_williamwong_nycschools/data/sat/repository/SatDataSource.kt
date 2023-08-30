package com.example.a20230829_williamwong_nycschools.data.sat.repository

import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.util.Result

interface SatDataSource {
    interface Remote {
        suspend fun getSatResults(schoolId: String): Result<SatResult>
    }
}