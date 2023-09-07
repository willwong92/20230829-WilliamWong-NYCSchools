package com.example.a20230829_williamwong_nycschools.data.sat.api

import com.example.a20230829_williamwong_nycschools.data.sat.dto.SatResultDto
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author by William Wong on 08/29/2023
 */
interface SatApiService {
    @GET("f9bf-2cp4.json")
    suspend fun getSatScores(@Query("dbn")query: String): List<SatResultDto>
}