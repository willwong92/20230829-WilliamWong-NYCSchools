package com.example.a20230829_williamwong_nycschools.data.school.mapper

import com.example.a20230829_williamwong_nycschools.data.school.dto.SchoolDto
import com.example.a20230829_williamwong_nycschools.domain.school.model.School

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