package com.liord.cocktails.domain

import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.data.CocktailRepository

class EditViewModel(
    private val repository: CocktailRepository
) : DetailsViewModel(repository) {

    fun save(
        name: String?,
        description: String?,
        ingredients: List<String>,
        recipe: String?,
        image: String? = null
    ) {
        if(name.isNullOrEmpty()){
            //show Error
        }
        repository.saveCocktail(Cocktail(name!!, description, ingredients, recipe, image))
    }
}