package com.example.a20230829_williamwong_nycschools.presentation.di.module

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Named
import javax.inject.Singleton

/**
 * @author by William Wong on 08/29/2023
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Singleton
    @Provides
    @Named("IO")
    fun provideBackgroundDispatchers(): CoroutineDispatcher = Dispatchers.IO

    @Singleton
    @Provides
    @Named("MAIN")
    fun provideMainDispatchers(): CoroutineDispatcher = Dispatchers.Main

    @Singleton
    @Provides
    @Named("DEFAULT")
    fun provideDefaultDispatchers(): CoroutineDispatcher = Dispatchers.Default
}