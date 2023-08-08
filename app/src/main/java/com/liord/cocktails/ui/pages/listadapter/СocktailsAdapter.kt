package com.liord.cocktails.ui.pages.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liord.cocktails.databinding.ItemListBinding
import com.liord.cocktails.domain.Сocktail


class СocktailsAdapter : RecyclerView.Adapter<СocktailViewHolder>() {

    private var items: MutableList<Сocktail> = mutableListOf()

    fun setItems(items: List<Сocktail>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = СocktailViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: СocktailViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int = items.size
}