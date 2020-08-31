package com.example.getcryptonews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cryptotracker.data.models.CryptoNewsItem
import com.example.cryptotracker.data.repositories.CryptoNewsRepository
import com.example.cryptotracker.utils.Coroutines
import kotlinx.coroutines.Job

class CryptoNewsViewModel(private val repository: CryptoNewsRepository) : ViewModel() {
    private lateinit var job: Job

    private val _news = MutableLiveData<List<CryptoNewsItem>>()
    val news: LiveData<List<CryptoNewsItem>>
        get() = _news


    fun getCryptoNews() {
        job = Coroutines.ioThenMain(
            { repository.getCryptoNews() },
            {
                _news.value = it
            }
        )
    }

    override fun onCleared() {
        super.onCleared()
        if (::job.isInitialized) job.cancel()
    }
}