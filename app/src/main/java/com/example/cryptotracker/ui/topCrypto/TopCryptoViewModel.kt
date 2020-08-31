package com.example.cryptotracker.ui.topCrypto

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptotracker.data.models.Data
import com.example.cryptotracker.data.repositories.TopCryptoRepository
import com.example.cryptotracker.utils.Coroutines
import kotlinx.coroutines.Job

class TopCryptoViewModel(
    private val repository: TopCryptoRepository
) : ViewModel() {
    private lateinit var job: Job

    private val _data = MutableLiveData<List<Data>>()
    val data: LiveData<List<Data>>
        get() = _data


    fun getTopCrypto() {
        job = Coroutines.ioThenMain(
            { repository.getTopCrypto() },
            {

                _data.value = it?.data
            }
        )
    }


    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}
