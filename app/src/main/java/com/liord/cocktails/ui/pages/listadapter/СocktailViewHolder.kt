package com.liord.cocktails.ui.pages.listadapter

import androidx.recyclerview.widget.RecyclerView
import com.liord.cocktails.databinding.ItemListBinding
import com.liord.cocktails.data.Cocktail

class CocktailViewHolder(
    private val itemBinding: ItemListBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(cocktail: Cocktail, listener: CocktailsAdapter.OnItemClickListener?) {
        with(itemBinding) {
            name.text = cocktail.name
        }
    }
}