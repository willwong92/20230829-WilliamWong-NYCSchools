package com.example.a20230829_williamwong_nycschools.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

/**
 * @author by William Wong on 08/29/2023
 */
abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {

    protected val binding: VB by lazy { inflateViewBinding(layoutInflater) }

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}