package com.example.a20230829_williamwong_nycschools.data

import com.example.a20230829_williamwong_nycschools.data.dto.SchoolDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author by William Wong on 08/29/2023
 */
interface SchoolApiService {
    @GET
    suspend fun getSchools(@Query(Constants.SCHOOL_NAME_QUERY)query: String): List<SchoolDto>
}