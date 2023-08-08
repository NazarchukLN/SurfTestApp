package com.liord.cocktails.ui.pages.listadapter

import androidx.recyclerview.widget.RecyclerView
import com.liord.cocktails.databinding.ItemListBinding
import com.liord.cocktails.domain.Сocktail

class СocktailViewHolder(
    private val itemBinding: ItemListBinding
) : RecyclerView.ViewHolder(itemBinding.root) {

    fun bind(cocktail: Сocktail) {
        with(itemBinding) {
            name.text = cocktail.name
        }
    }
}