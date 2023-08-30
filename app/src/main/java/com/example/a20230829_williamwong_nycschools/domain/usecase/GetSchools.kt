package com.example.a20230829_williamwong_nycschools.domain.usecase

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.domain.model.School
import com.example.a20230829_williamwong_nycschools.domain.repository.SchoolRepository

/**
 * @author by William Wong on 08/29/2023
 */
class GetSchools(
    private val schoolRepository: SchoolRepository
) {
    suspend operator fun invoke(): Result<List<School>> = schoolRepository.getSchools()
}