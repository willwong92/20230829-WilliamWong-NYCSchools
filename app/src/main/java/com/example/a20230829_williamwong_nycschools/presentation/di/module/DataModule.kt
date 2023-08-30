package com.example.a20230829_williamwong_nycschools.presentation.di.module

import com.example.a20230829_williamwong_nycschools.data.SchoolApiService
import com.example.a20230829_williamwong_nycschools.data.repository.SchoolDataSource
import com.example.a20230829_williamwong_nycschools.data.repository.SchoolRemoteDataSource
import com.example.a20230829_williamwong_nycschools.data.repository.SchoolRepositoryImpl
import com.example.a20230829_williamwong_nycschools.domain.repository.SchoolRepository
import com.example.a20230829_williamwong_nycschools.domain.usecase.GetSchools
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