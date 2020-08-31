package com.example.cryptotracker.data.network

import com.example.cryptotracker.data.models.CryptoNewsItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers


interface CryptoNewsApi {
    @Headers(
        "x-api-key: 6f7e6e6a06a01e935d2daa3f1c0223f1"
    )

    @GET("/api/v1/public/news")
    suspend fun getTopCrypto(): Response<List<CryptoNewsItem>>

    companion object {
        operator fun invoke(): CryptoNewsApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://cryptocontrol.io")
                .build()
                .create(CryptoNewsApi::class.java)
        }
    }

}
