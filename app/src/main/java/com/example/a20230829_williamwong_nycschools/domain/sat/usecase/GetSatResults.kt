package com.example.a20230829_williamwong_nycschools.domain.sat.usecase

import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult
import com.example.a20230829_williamwong_nycschools.domain.sat.repository.SatRepository
import com.example.a20230829_williamwong_nycschools.domain.util.Result

/**
 * @author by William Wong on 08/29/2023
 */
class GetSatResults(
    private val satRepository: SatRepository
) {
    suspend operator fun invoke(schoolId: String): Result<SatResult> = satRepository.getSatResults(schoolId)
}