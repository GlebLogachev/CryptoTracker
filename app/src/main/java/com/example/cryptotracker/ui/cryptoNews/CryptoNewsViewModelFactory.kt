package com.example.getcryptonews

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptotracker.data.repositories.CryptoNewsRepository

@Suppress("UNCHECKED_CAST")
class CryptoNewsViewModelFactory(
    private val repository: CryptoNewsRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CryptoNewsViewModel(
            repository
        ) as T
    }
}