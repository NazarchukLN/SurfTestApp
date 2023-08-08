package com.liord.cocktails.ui.pages.listadapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liord.cocktails.databinding.ItemListBinding
import com.liord.cocktails.data.Cocktail


class CocktailsAdapter : RecyclerView.Adapter<CocktailViewHolder>() {

    private var items: MutableList<Cocktail> = mutableListOf()

    private var listener: OnItemClickListener? = null

    fun setItems(items: List<Cocktail>) {
        this.items = items.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = CocktailViewHolder(
        ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: CocktailViewHolder, position: Int) {
        holder.bind(items[position], listener)
    }

    override fun getItemCount(): Int = items.size

    fun setOnItemClickListener(listener: OnItemClickListener?) {
        this.listener = listener
    }

    interface OnItemClickListener {

        fun onItemClick(cocktail: Cocktail)
    }
}