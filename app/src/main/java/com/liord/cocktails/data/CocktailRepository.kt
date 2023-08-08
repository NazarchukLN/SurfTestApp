package com.liord.cocktails.data

import kotlinx.coroutines.flow.Flow

/**
 * it is more correct to separate this interface according
 * to the principle of separating interfaces from SOLID
 */
interface CocktailRepository {

    fun getCocktails(): Flow<List<Cocktail>>

    fun getCocktail(id: String): Flow<Cocktail>

    /**
     * in case of successful save this method return the id, otherwise error
     */
    fun saveCocktail(cocktail: Cocktail): Flow<String>
}