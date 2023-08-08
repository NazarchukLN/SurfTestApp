package com.liord.cocktails.data

data class Cocktail(
    val name: String,
    val description: String?,
    val ingredients: List<String>,
    val recipe: String?,
    val image: String? = null
)
