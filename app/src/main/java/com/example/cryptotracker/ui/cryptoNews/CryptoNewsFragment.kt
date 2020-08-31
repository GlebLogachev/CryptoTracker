package com.example.getcryptonews

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.cryptotracker.R
import com.example.cryptotracker.data.network.CryptoNewsApi
import com.example.cryptotracker.data.repositories.CryptoNewsRepository
import kotlinx.android.synthetic.main.fragment_crypto_news.*


class CryptoNewsFragment : Fragment() {

    private lateinit var factory: CryptoNewsViewModelFactory
    private lateinit var viewModel: CryptoNewsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_crypto_news, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = CryptoNewsApi()
        val repository =
            CryptoNewsRepository(api)

        factory = CryptoNewsViewModelFactory(
            repository
        )

        viewModel = ViewModelProviders.of(this, factory).get(CryptoNewsViewModel::class.java)
        viewModel.getCryptoNews()
        viewModel.news.observe(viewLifecycleOwner, Observer { news ->
            crypto_news_rv.also {
                it.adapter = CryptoNewsAdapter(news)
            }
        })
    }

}

