package com.example.a20230829_williamwong_nycschools.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import javax.inject.Inject

/**
 * @author by William Wong on 08/29/2023
 */
abstract class BaseFragment<VB: ViewBinding> : DialogFragment() {

    protected val binding: VB by lazy { inflateViewBinding(layoutInflater) }

    protected abstract fun inflateViewBinding(inflater: LayoutInflater): VB

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View = binding.root
}