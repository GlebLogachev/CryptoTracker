package com.example.cryptotracker.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.cryptotracker.R
import com.example.cryptotracker.ui.topCrypto.TopCryptoFragment
import com.example.getcryptonews.CryptoNewsFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val manager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cryptoNewsFragment = CryptoNewsFragment()
        val topCryptoFragment = TopCryptoFragment()

        makeCurentFragment(topCryptoFragment)


        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.icon_news -> makeCurentFragment(cryptoNewsFragment)
                R.id.icon_crypto -> makeCurentFragment(topCryptoFragment)
            }
            true
        }
    }

    private fun makeCurentFragment(fragment: Fragment) {
        manager.beginTransaction().apply {
            replace(R.id.holder, fragment)
            commit()
        }
    }
}

