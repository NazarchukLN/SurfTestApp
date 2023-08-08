package com.liord.cocktails.ui.pages

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.liord.cocktails.R
import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.databinding.FragmentDetailsBinding
import com.liord.cocktails.domain.DetailsViewModel
import com.liord.cocktails.getInfo
import com.liord.cocktails.launchWhenStarted
import com.liord.cocktails.ui.MainActivity

class DetailsFragment : BaseFragment<FragmentDetailsBinding>() {

    private val viewModel: DetailsViewModel by viewModels {
        ViewModelFactory(MainActivity.repository)
    }

    override fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?) =
        FragmentDetailsBinding.inflate(inflater, viewGroup, false)

    private val cocktailId: String? by lazy {
        arguments?.getString(EXTRA_COCKTAIL_ID)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.loadDetails(cocktailId)
    }

    private fun initViews() {
        views {
            info.movementMethod = ScrollingMovementMethod()
            editButton.setOnClickListener {

            }
        }
        viewModel.details.launchWhenStarted(lifecycleScope) { cocktail ->
            cocktail?.let {
                showDetailsInfo(it)
            }
        }
    }

    private fun showDetailsInfo(cocktail: Cocktail){
        views {
            title.text = cocktail.name
            info.text = cocktail.getInfo(resources.getString(R.string.recipe))
        }
    }

    companion object {

        private const val EXTRA_COCKTAIL_ID = "cocktail_id"

        fun getInstance(cocktailId: String): Fragment =
            DetailsFragment().apply {
                arguments = bundleOf(EXTRA_COCKTAIL_ID to cocktailId)
            }
    }
}