package com.helloworldstudios.retrofitsample

import com.helloworldstudios.retrofitsample.model.CryptoModel

class CryptoModelRepository {
    private val cryptoAPI = RetrofitInstance.cryptoAPI

    suspend fun getCryptoCurrencies(): List<CryptoModel> {
        return cryptoAPI.getCryptoCurrencies()
    }
}