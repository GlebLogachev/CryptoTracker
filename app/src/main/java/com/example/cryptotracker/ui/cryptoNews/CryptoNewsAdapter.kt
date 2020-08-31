package com.example.getcryptonews

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cryptotracker.R
import com.example.cryptotracker.data.models.CryptoNewsItem
import com.makeramen.roundedimageview.RoundedTransformationBuilder
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation

class CryptoNewsAdapter(private val news: List<CryptoNewsItem>) :
    RecyclerView.Adapter<TopCryptoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopCryptoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.crypto_news_items, parent, false)
        return TopCryptoViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size

    }

    override fun onBindViewHolder(holder: TopCryptoViewHolder, position: Int) {
        val item = news[position]!!
        holder.bind(item)
    }
}

class TopCryptoViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    fun bind(item: CryptoNewsItem) {
        val vWords = itemView.findViewById<TextView>(R.id.words)
        val vDesc = itemView.findViewById<TextView>(R.id.description)
        val vTitle = itemView.findViewById<TextView>(R.id.title)
        val vThumb = itemView.findViewById<ImageView>(R.id.thumbnail)


        vTitle.text = item.title
        vDesc.text = item.description
        vWords.text = item.words.toString() + "words"

        val transformation: Transformation = RoundedTransformationBuilder()
            .borderWidthDp(1F)
            .oval(true)
            .cornerRadiusDp(10F)
            .build()

        Picasso.with(itemView.context).load(item.thumbnail)
            .transform(transformation)
            .into(vThumb)


    }
}