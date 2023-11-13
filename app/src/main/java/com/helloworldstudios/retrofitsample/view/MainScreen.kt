package com.helloworldstudios.retrofitsample.view

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.helloworldstudios.retrofitsample.CryptoModelViewModel
import com.helloworldstudios.retrofitsample.model.CryptoModel

@Composable
fun MainScreen(viewModel: CryptoModelViewModel) {
    val cryptoCurrencies by viewModel.cryptoCurrencies.observeAsState(emptyList())

    LaunchedEffect(Unit){
        viewModel.fetchCryptoCurrencies()
    }

    if (cryptoCurrencies.isEmpty()){
        Text(text = "Loading...")
    } else{
        ListCryptoModels(cryptoCurrencies = cryptoCurrencies)
    }

}

@Composable
fun ListCryptoModel(cryptoCurrency: CryptoModel){
    Column(modifier = Modifier.fillMaxWidth().padding(10.dp)) {
        Text(text = "${cryptoCurrency.currency} : ${cryptoCurrency.price}")
    }
}

@Composable
fun ListCryptoModels(cryptoCurrencies: List<CryptoModel>) {

    LazyColumn(
        modifier = Modifier.border(3.dp, Color.Blue),
        verticalArrangement = Arrangement.Top,
        userScrollEnabled = true
    ) {
        this.items(cryptoCurrencies){
            ListCryptoModel(cryptoCurrency = it)
        }
    }
}