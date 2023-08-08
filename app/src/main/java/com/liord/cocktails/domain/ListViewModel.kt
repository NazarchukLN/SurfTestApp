package com.liord.cocktails.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liord.cocktails.data.Cocktail
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val _items = MutableStateFlow(emptyList<Cocktail>())
    val items: StateFlow<List<Cocktail>> = _items.asStateFlow()

    fun loadItems() {
        viewModelScope.launch {
            val empty = emptyList<Cocktail>()
            val items = listOf(Cocktail("item 1"), Cocktail("item 2"), Cocktail("item 3"))
            flowOf(items).collect { result ->
                _items.value = result
            }
        }
    }

    fun openItem(position: Int) {

    }

    fun addItem() {

    }
}