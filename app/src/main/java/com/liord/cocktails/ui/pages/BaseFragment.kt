package com.liord.cocktails.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<T : ViewBinding>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    private var fragmentBinding: T? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        fragmentBinding = bindView(inflater, container)
        return fragmentBinding?.root
    }

    abstract fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?): T

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentBinding = null
    }

    protected fun views(block: T.() -> Unit) {
        fragmentBinding?.block()
    }
}