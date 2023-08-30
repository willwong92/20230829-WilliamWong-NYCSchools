package com.example.a20230829_williamwong_nycschools.presentation.di.main

import android.os.Bundle
import android.view.LayoutInflater
import com.example.a20230829_williamwong_nycschools.R
import com.example.a20230829_williamwong_nycschools.databinding.ActivityMainBinding
import com.example.a20230829_williamwong_nycschools.presentation.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author by William Wong on 08/29/2023
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding = ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}