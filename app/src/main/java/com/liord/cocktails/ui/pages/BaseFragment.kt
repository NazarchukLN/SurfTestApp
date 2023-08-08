package com.liord.cocktails.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.viewbinding.ViewBinding
import com.liord.cocktails.R

abstract class BaseFragment<T : ViewBinding> : Fragment() {

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

    protected fun showFragment(
        fragment: Fragment,
        containerId: Int = R.id.main_container,
        addToStack: Boolean = true
    ) {
        parentFragmentManager.commit {
            replace(containerId, fragment, fragment.javaClass.simpleName)
            if (addToStack) {
                addToBackStack("")
            }
        }
    }
}