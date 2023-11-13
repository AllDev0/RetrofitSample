package com.helloworldstudios.retrofitsample.service

import com.helloworldstudios.retrofitsample.model.CryptoModel
import retrofit2.Call
import retrofit2.http.GET

interface CryptoAPI {
    @GET("atilsamancioglu/K21-JSONDataSet/master/crypto.json")
    suspend fun getCryptoCurrencies() : List<CryptoModel>
}