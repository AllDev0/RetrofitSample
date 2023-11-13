package com.helloworldstudios.retrofitsample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.helloworldstudios.retrofitsample.model.CryptoModel
import kotlinx.coroutines.launch

class CryptoModelViewModel : ViewModel() {
    private val repository = CryptoModelRepository()

    private val _cryptoCurrencies = MutableLiveData<List<CryptoModel>>()
    val cryptoCurrencies: LiveData<List<CryptoModel>> = _cryptoCurrencies

    fun fetchCryptoCurrencies(){
        viewModelScope.launch {
            try {
                val cryptos = repository.getCryptoCurrencies()

                _cryptoCurrencies.value = cryptos
            } catch (e: Exception){
                e.printStackTrace()
            }

        }
    }
}