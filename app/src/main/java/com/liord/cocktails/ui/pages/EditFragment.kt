package com.liord.cocktails.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.databinding.FragmentEditBinding
import com.liord.cocktails.domain.EditViewModel
import com.liord.cocktails.launchWhenStarted
import com.liord.cocktails.ui.MainActivity

class EditFragment : BaseFragment<FragmentEditBinding>() {

    private val viewModel: EditViewModel by viewModels {
        ViewModelFactory(MainActivity.repository)
    }

    private val cocktailId: String? by lazy {
        arguments?.getString(EXTRA_COCKTAIL_ID)
    }

    override fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?) =
        FragmentEditBinding.inflate(inflater, viewGroup, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.loadDetails(cocktailId)
    }

    private fun initViews() {
        views {
            saveButton.setOnClickListener {
                viewModel.save(
                    name = inputTitle.editText?.text?.toString(),
                    description = inputDesc.editText?.text?.toString(),
                    recipe = inputRecipe.editText?.text?.toString(),
                    ingredients = listOf()
                )
            }
            cancelButton.setOnClickListener {
                parentFragmentManager.popBackStack();
            }
        }
        viewModel.details.launchWhenStarted(lifecycleScope) { cocktail ->
            cocktail?.let {
                showDetailsInfo(it)
            }
        }
    }

    private fun showDetailsInfo(cocktail: Cocktail) {
        views {
            inputTitle.editText?.setText(cocktail.name)
            inputDesc.editText?.setText(cocktail.description)
            inputRecipe.editText?.setText(cocktail.recipe)
        }
    }

    companion object {

        private const val EXTRA_COCKTAIL_ID = "cocktail_id"

        fun getInstance(cocktailId: String?): Fragment =
            EditFragment().apply {
                cocktailId?.let {
                    arguments = bundleOf(EXTRA_COCKTAIL_ID to it)
                }
            }
    }
}