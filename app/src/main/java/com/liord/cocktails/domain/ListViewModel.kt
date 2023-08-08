package com.liord.cocktails.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.data.CocktailRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class ListViewModel(
    private val repository: CocktailRepository
) : ViewModel() {

    private val _items = MutableStateFlow(emptyList<Cocktail>())
    val items: StateFlow<List<Cocktail>> = _items.asStateFlow()

    fun loadItems() {
        viewModelScope.launch {
            repository.getCocktails().collect { result ->
                _items.value = result
            }
        }
    }
}