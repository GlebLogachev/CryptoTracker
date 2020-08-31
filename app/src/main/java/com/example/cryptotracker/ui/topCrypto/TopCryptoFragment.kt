package com.example.cryptotracker.ui.topCrypto

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.cryptotracker.R
import com.example.cryptotracker.data.network.TopCryptoApi
import com.example.cryptotracker.data.repositories.TopCryptoRepository
import kotlinx.android.synthetic.main.top_crypto_fragment.*


class TopCryptoFragment : Fragment() {


    private lateinit var factory: TopCryptoViewModelFactory
    private lateinit var viewModel: TopCryptoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.top_crypto_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val api = TopCryptoApi()
        val repository =
            TopCryptoRepository(api)
        factory =
            TopCryptoViewModelFactory(
                repository
            )
        viewModel = ViewModelProviders.of(this, factory).get(TopCryptoViewModel::class.java)
        viewModel.getTopCrypto()
        viewModel.data.observe(viewLifecycleOwner, Observer { crypto ->
            top_crypto_rw.also {
                it.setHasFixedSize(true)
                it.adapter =
                    TopCryptoAdapter(
                        crypto
                    )
            }
        })
    }
}
