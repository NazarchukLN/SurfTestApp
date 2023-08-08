package com.liord.cocktails.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.liord.cocktails.R
import com.liord.cocktails.createTestCocktail
import com.liord.cocktails.data.Cocktail
import com.liord.cocktails.data.CocktailRepository
import com.liord.cocktails.databinding.ActivityMainBinding
import com.liord.cocktails.ui.pages.ListFragment
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(ListFragment(), addToStack = false)
    }

    private fun showFragment(
        fragment: Fragment,
        containerId: Int = R.id.main_container,
        addToStack: Boolean = true
    ) {
        supportFragmentManager.commit {
            add(containerId, fragment, fragment.javaClass.simpleName)
            if (addToStack) {
                addToBackStack("")
            }
        }
    }

    companion object{
        val repository = object : CocktailRepository{
            override fun getCocktails(): Flow<List<Cocktail>> = flowOf(
                listOf(
                    createTestCocktail(),
                    createTestCocktail(),
                    createTestCocktail(),
                    createTestCocktail(),
                    createTestCocktail(),
                    createTestCocktail(),
                )
            )

            override fun getCocktail(id: String): Flow<Cocktail> = flowOf(createTestCocktail())

            override fun saveCocktail(cocktail: Cocktail): Flow<String> = flowOf()
        }
    }
}