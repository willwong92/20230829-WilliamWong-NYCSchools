package com.example.a20230829_williamwong_nycschools.data.sat.mapper

import com.example.a20230829_williamwong_nycschools.data.sat.dto.SatResultDto
import com.example.a20230829_williamwong_nycschools.domain.sat.model.SatResult

/**
 * @author by William Wong on 08/29/2023
 */
fun SatResultDto.toDomain() =  SatResult(
    id = id,
    schoolName = schoolName,
    testTakers = testTakers,
    criticalReadingAvgScore = criticalReadingAvgScore,
    mathAvgScore = mathAvgScore,
    writingAvgScore = writingAvgScore
)