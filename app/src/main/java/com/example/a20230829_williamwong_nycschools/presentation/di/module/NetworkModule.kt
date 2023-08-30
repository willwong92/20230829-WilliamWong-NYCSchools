package com.example.a20230829_williamwong_nycschools.presentation.di.module

import com.example.a20230829_williamwong_nycschools.data.Constants.Companion.SCHOOL_BASE_URL
import com.example.a20230829_williamwong_nycschools.data.sat.api.SatApiService
import com.example.a20230829_williamwong_nycschools.data.school.api.SchoolApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/**
 * @author by William Wong on 08/29/2023
 */
@Module
@InstallIn(SingletonComponent::class)
class NetworkModule {
    @Singleton
    @Provides
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        interceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .build()

    }

    @Singleton
    @Provides
    fun provideRetrofitSchoolService(
        okHttpClient: OkHttpClient
    ): SchoolApiService {
        return Retrofit.Builder()
            .baseUrl(SCHOOL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SchoolApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideRetrofitSatResultService(
        okHttpClient: OkHttpClient
    ): SatApiService {
        return Retrofit.Builder()
            .baseUrl(SCHOOL_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
            .create(SatApiService::class.java)
    }
}