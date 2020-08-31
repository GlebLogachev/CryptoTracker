package com.example.cryptotracker.ui.topCrypto

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.cryptotracker.data.repositories.TopCryptoRepository


@Suppress("UNCHECKED_CAST")
class TopCryptoViewModelFactory(
    private val repository: TopCryptoRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TopCryptoViewModel(
            repository
        ) as T
    }
}