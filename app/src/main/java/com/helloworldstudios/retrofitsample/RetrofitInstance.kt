package com.helloworldstudios.retrofitsample

import com.helloworldstudios.retrofitsample.service.CryptoAPI
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://raw.githubusercontent.com/"

    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val cryptoAPI: CryptoAPI by lazy {
        retrofit.create(CryptoAPI::class.java)
    }
}