package com.liord.cocktails.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.data.CocktailRepository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class DetailsViewModel(
    private val repository: CocktailRepository
) : ViewModel() {

    private val _details = MutableStateFlow<Cocktail?>(null)
    val details: StateFlow<Cocktail?> = _details.asStateFlow()

    fun loadDetails(cocktailId: String?) {
        viewModelScope.launch {
            cocktailId?.let {
                repository.getCocktail(cocktailId).collect { result ->
                    _details.value = result
                }
            } //?: show Error
        }
    }
}