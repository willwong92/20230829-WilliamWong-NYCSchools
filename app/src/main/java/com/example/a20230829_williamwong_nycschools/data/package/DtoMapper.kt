package com.example.a20230829_williamwong_nycschools.data.`package`

import com.example.a20230829_williamwong_nycschools.data.dto.SchoolDto
import com.example.a20230829_williamwong_nycschools.domain.model.School

/**
 * @author by William Wong on 08/29/2023
 */
fun SchoolDto.toDomain() =  School(
    id = id,
    schoolName = schoolName,
    location = location,
    city = city,
    zipCode = zipCode
)