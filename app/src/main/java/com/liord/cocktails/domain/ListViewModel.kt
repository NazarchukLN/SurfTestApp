package com.liord.cocktails.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val _items = MutableStateFlow(emptyList<Сocktail>())
    val items: StateFlow<List<Сocktail>> = _items.asStateFlow()

    fun loadItems() {
        viewModelScope.launch {
            val empty = emptyList<Сocktail>()
            val items = listOf(Сocktail("item 1"), Сocktail("item 2"), Сocktail("item 3"))
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