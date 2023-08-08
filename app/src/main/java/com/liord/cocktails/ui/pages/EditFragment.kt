package com.liord.cocktails.ui.pages

import android.view.LayoutInflater
import android.view.ViewGroup
import com.liord.cocktails.databinding.FragmentEditBinding

class EditFragment : BaseFragment<FragmentEditBinding>() {

    override fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?) =
        FragmentEditBinding.inflate(inflater, viewGroup, false)
}