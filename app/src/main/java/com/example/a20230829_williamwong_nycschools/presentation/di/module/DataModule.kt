package com.example.a20230829_williamwong_nycschools.presentation.di.module

import com.example.a20230829_williamwong_nycschools.data.sat.api.SatApiService
import com.example.a20230829_williamwong_nycschools.data.sat.repository.SatDataSource
import com.example.a20230829_williamwong_nycschools.data.sat.repository.SatRemoteDataSource
import com.example.a20230829_williamwong_nycschools.data.sat.repository.SatRepositoryImpl
import com.example.a20230829_williamwong_nycschools.data.school.api.SchoolApiService
import com.example.a20230829_williamwong_nycschools.data.school.repository.SchoolDataSource
import com.example.a20230829_williamwong_nycschools.data.school.repository.SchoolRemoteDataSource
import com.example.a20230829_williamwong_nycschools.data.school.repository.SchoolRepositoryImpl
import com.example.a20230829_williamwong_nycschools.domain.sat.repository.SatRepository
import com.example.a20230829_williamwong_nycschools.domain.sat.usecase.GetSatResults
import com.example.a20230829_williamwong_nycschools.domain.school.repository.SchoolRepository
import com.example.a20230829_williamwong_nycschools.domain.school.usecase.GetSchools
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author by William Wong on 08/29/2023
 */
@Module
@InstallIn(SingletonComponent::class)
class DataModule {

    @Provides
    @Singleton
    fun provideSatRepository(
        satRemote: SatDataSource.Remote
    ): SatRepository {
        return SatRepositoryImpl(satRemote)
    }

    @Provides
    @Singleton
    fun provideSatRemoteDataSource(
        satApiService: SatApiService,
        @Named("IO")
        dispatchers: CoroutineDispatcher
    ): SatDataSource.Remote {
        return SatRemoteDataSource(satApiService, dispatchers)
    }

    @Provides
    fun provideGetSatResultsUseCase(
        satRepository: SatRepository
    ): GetSatResults {
        return GetSatResults(satRepository)
    }

    @Provides
    @Singleton
    fun provideSchoolRepository(
        schoolRemote: SchoolDataSource.Remote,
    ): SchoolRepository {
        return SchoolRepositoryImpl(schoolRemote)
    }

    @Provides
    @Singleton
    fun provideSchoolRemoteDataSource(
        schoolApiService: SchoolApiService,
        @Named("IO")
        dispatchers: CoroutineDispatcher
    ): SchoolDataSource.Remote {
        return SchoolRemoteDataSource(schoolApiService, dispatchers)
    }

    @Provides
    fun provideGetSchoolsUseCase(
        schoolRepository: SchoolRepository
    ): GetSchools {
        return GetSchools(schoolRepository)
    }
}