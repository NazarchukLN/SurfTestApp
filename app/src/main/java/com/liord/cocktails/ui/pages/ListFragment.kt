package com.liord.cocktails.ui.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.liord.cocktails.R
import com.liord.cocktails.databinding.FragmentListBinding
import com.liord.cocktails.domain.ListViewModel
import com.liord.cocktails.domain.Сocktail
import com.liord.cocktails.launchWhenStarted
import com.liord.cocktails.ui.pages.listadapter.СocktailsAdapter

class ListFragment : BaseFragment<FragmentListBinding>(R.layout.fragment_list) {

    private val viewModel: ListViewModel by viewModels()
    private val cocktailsAdapter = СocktailsAdapter()

    override fun bindView(inflater: LayoutInflater, viewGroup: ViewGroup?) =
        FragmentListBinding.inflate(inflater, viewGroup, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
        viewModel.loadItems()
    }

    private fun initViews() {
        views {
            list.apply {
                layoutManager = GridLayoutManager(context, 2)
                setHasFixedSize(true)
                adapter = cocktailsAdapter
            }
        }
        viewModel.items.launchWhenStarted(lifecycleScope) { items ->
            initState(items)
        }
    }

    private fun initState(items: List<Сocktail>) {
        views {
            val isShowItems = items.isNotEmpty()
            image.isVisible = !isShowItems
            info.isVisible = !isShowItems
            list.isVisible = isShowItems
            if (isShowItems) {
                showItems(items)
            }
        }
    }

    private fun showItems(items: List<Сocktail>) {
        cocktailsAdapter.setItems(items)
    }
}