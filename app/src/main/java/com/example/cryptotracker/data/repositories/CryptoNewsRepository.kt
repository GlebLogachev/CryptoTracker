package com.example.cryptotracker.data.repositories

import com.example.cryptotracker.data.network.CryptoNewsApi
import com.example.getcryptonews.CryptoNewsSafeApiRequest

class CryptoNewsRepository(
    private val api: CryptoNewsApi
) : CryptoNewsSafeApiRequest() {
    suspend fun getCryptoNews() = apiRequest { api.getTopCrypto() }
}