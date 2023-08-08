package com.liord.cocktails

import androidx.lifecycle.LifecycleCoroutineScope
import com.liord.cocktails.data.Cocktail
import kotlinx.coroutines.flow.Flow
import java.lang.StringBuilder

fun <T> Flow<T>.launchWhenStarted(
    lifecycleScope: LifecycleCoroutineScope,
    onResult: (T) -> Unit
) {
    lifecycleScope.launchWhenStarted {
        this@launchWhenStarted.collect {
            onResult(it)
        }
    }
}

private const val SPACING = "\n"
private const val SPACING_INGREDIENT = "\n--\n"

fun Cocktail.getInfo(recipeText: String): String {
    val result = StringBuilder()
    result.append(description).append(SPACING).append(SPACING)
    result.append(ingredients.joinToString(postfix = SPACING, separator = SPACING_INGREDIENT))
    result.append(SPACING).append(recipeText).append(SPACING).append(recipe)
    result.append(SPACING)
    return result.toString()
}

fun createTestCocktail() = Cocktail(
    name = "Mojito mocktail",
    description = "To make this homemade lemonade, simply combine all the ingredients in a pitcher.",
    ingredients = listOf(
        "9 cups sprite",
        "small bunch mint",
        "3 limes, juiced",
    ),
    recipe = "Muddle lime with leaves from the mint using a pestle and mortar. Mix with sprite. Add ice if needed."
)