package com.liord.cocktails.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.liord.cocktails.R
import com.liord.cocktails.databinding.ActivityMainBinding
import com.liord.cocktails.ui.pages.ListFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showFragment(ListFragment())
    }

    protected fun showFragment(
        fragment: Fragment,
        containerId: Int = R.id.main_container,
        addToStack: Boolean = false
    ) {
        supportFragmentManager.commit {
            add(containerId, fragment, fragment.javaClass.simpleName)
            if (addToStack) {
                addToBackStack("")
            }
        }
    }
}