package com.example.a20230829_williamwong_nycschools.presentation.ui.main

import android.view.LayoutInflater
import com.example.a20230829_williamwong_nycschools.databinding.ActivityMainBinding
import com.example.a20230829_williamwong_nycschools.presentation.ui.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

/**
 * @author by William Wong on 08/29/2023
 */
@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun inflateViewBinding(inflater: LayoutInflater): ActivityMainBinding = ActivityMainBinding.inflate(inflater)

}