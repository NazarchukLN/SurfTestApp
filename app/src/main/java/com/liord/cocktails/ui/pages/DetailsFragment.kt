package com.liord.cocktails.ui.pages

import android.view.LayoutInflater
import android.view.ViewGroup
import com.liord.cocktails.databinding.FragmentDetailsBinding

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    override fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?) =
        FragmentDetailsBinding.inflate(inflater, viewGroup, false)
}