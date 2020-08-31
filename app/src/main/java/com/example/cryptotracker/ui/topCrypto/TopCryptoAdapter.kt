package com.example.cryptotracker.ui.topCrypto

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.data.models.Data
import com.squareup.picasso.Picasso
import java.math.RoundingMode
import java.text.DecimalFormat


class TopCryptoAdapter(private val crypto: List<Data>) :
    RecyclerView.Adapter<TopCryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopCryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.top_crypto_rw_items, parent, false)
        return TopCryptoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return crypto.size

    }

    override fun onBindViewHolder(holder: TopCryptoViewHolder, position: Int) {
        val item = crypto[position]!!
        holder.bind(item)
    }
}

class TopCryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: Data) {
        val vName = itemView.findViewById<TextView>(R.id.coinName)
        val vSymbol = itemView.findViewById<TextView>(R.id.coinSymbol)
        val vPrice = itemView.findViewById<TextView>(R.id.coinPrice)
        val vOneHourChange = itemView.findViewById<TextView>(R.id.percentChange1hText)
        val vTwentyFourHourChange = itemView.findViewById<TextView>(R.id.percentChange24hText)
        val vSevenDayChange = itemView.findViewById<TextView>(R.id.percentChange7dayText)
        val vCoinIcon = itemView.findViewById<ImageView>(R.id.coinIcon)


        vName.text = item.name
        vSymbol.text = item.symbol

        val df = DecimalFormat("#.##")
        df.roundingMode = RoundingMode.CEILING

        vPrice.text = df.format(item.quote.USD.price.toDouble())
        vOneHourChange.text = df.format(item.quote.USD.percent_change_1h.toDouble())
        vTwentyFourHourChange.text = df.format(item.quote.USD.percent_change_24h.toDouble())
        vSevenDayChange.text = df.format(item.quote.USD.percent_change_7d.toDouble())


        val imageUrl = "https://res.cloudinary.com/dkr1ikdhl/image/upload/v1579713968/"
        Picasso.with(itemView.context).load(imageUrl + item.symbol.toLowerCase() + ".png")
            .into(vCoinIcon)

        vOneHourChange.setTextColor(
            Color.parseColor(
                when {
                    vOneHourChange.text.contains("-") -> "#ff0000"
                    else -> "#32CD32"
                }
            )
        )
        vTwentyFourHourChange.setTextColor(
            Color.parseColor(
                when {
                    vTwentyFourHourChange.text.contains("-") -> "#ff0000"
                    else -> "#32CD32"
                }
            )
        )
        vSevenDayChange.setTextColor(
            Color.parseColor(
                when {
                    vSevenDayChange.text.contains("-") -> "#ff0000"
                    else -> "#32CD32"
                }
            )
        )
    }
}


