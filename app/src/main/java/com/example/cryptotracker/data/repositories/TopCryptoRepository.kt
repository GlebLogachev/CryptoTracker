package com.example.cryptotracker.data.repositories

import com.example.cryptotracker.data.network.TopCryptoApi

class TopCryptoRepository(
    private val api: TopCryptoApi
) : SafeApiRequest() {
    suspend fun getTopCrypto() = apiRequest { api.getTopCrypto() }
}