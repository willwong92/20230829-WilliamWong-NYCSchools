package com.example.a20230829_williamwong_nycschools.presentation

import android.app.Application
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.WorkManager
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

/**
 * @author by William Wong on 08/29/2023
 */
@HiltAndroidApp
class App : Application()