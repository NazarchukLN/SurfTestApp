package com.liord.cocktails

import androidx.lifecycle.LifecycleCoroutineScope
import kotlinx.coroutines.flow.Flow

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