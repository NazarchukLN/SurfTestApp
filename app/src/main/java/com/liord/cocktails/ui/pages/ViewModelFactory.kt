package com.liord.cocktails.ui.pages

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.liord.cocktails.data.CocktailRepository

class ViewModelFactory(
    private val repository: CocktailRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T =
        modelClass.getConstructor(CocktailRepository::class.java).newInstance(
            repository
        )
}