package com.example.a20230829_williamwong_nycschools.data.repository

import com.example.a20230829_williamwong_nycschools.domain.util.Result
import com.example.a20230829_williamwong_nycschools.domain.model.School

/**
 * @author by William Wong on 08/29/2023
 */
interface SchoolDataSource {
    interface Remote {
        suspend fun getSchools(): Result<List<School>>
    }
}