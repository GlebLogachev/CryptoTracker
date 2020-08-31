package com.example.cryptotracker.data.network

import com.example.cryptotracker.data.models.TopCryptoModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers

interface TopCryptoApi {
    @Headers(
        "X-CMC_PRO_API_KEY: d6ebc6e7-16f1-4e48-ad52-df7589cd61c2",
        "Accept: application/json"
    )

    @GET("v1/cryptocurrency/listings/latest?limit=30&start=1")
    suspend fun getTopCrypto(): Response<TopCryptoModel>

    companion object {
        operator fun invoke(): TopCryptoApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://pro-api.coinmarketcap.com/")
                .build()
                .create(TopCryptoApi::class.java)
        }
    }
}