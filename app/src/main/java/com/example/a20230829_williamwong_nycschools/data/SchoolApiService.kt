package com.example.a20230829_williamwong_nycschools.data

import com.example.a20230829_williamwong_nycschools.data.dto.SchoolDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author by William Wong on 08/29/2023
 */
interface SchoolApiService {
    @GET("s3k6-pzi2.json")
    suspend fun getSchools(@Query("\$limit")query: Int = Constants.PAGE_SIZE): List<SchoolDto>
}