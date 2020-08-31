package com.example.cryptotracker.data.models

class CryptoNews : ArrayList<CryptoNewsItem>()

data class CryptoNewsItem(
    val description: String,
    val thumbnail: String,
    val title: String,
    val url: String,
    val words: Int
)

/*
[
{
    "_id": "5b583462c4be0b000fce9263",
    "hotness": 70954.00327655903,
    "activityHotness": 4.601980262729618,
    "primaryCategory": "Mining",
    "words": 461,
    "similarArticles": [
    {
        "_id": "5b57b7fb38c5f4000f72b680",
        "sourceDomain": "bcfocus.com",
        "item": "https://cryptocontrol.io/r/api/article/5b57b7fb38c5f4000f72b680",
        "thumbnail": "https://cryptocontrol.io/r/thumbnail/5b582ea4c4be0b000fce673f"
    }
    ...
    ],
    "coins": [
    {
        "_id": "59cb59e81c073f09e76f614b",
        "name": "Bitcoin",
        "slug": "bitcoin",
        "tradingSymbol": "btc"
    },
    ...
    ],
    "description": "Professional services giant PricewaterhouseCoopers Switzerland will conduct an external audit of the Tezos Foundation, which is the first time when a blockchain organization is accepted as an audit client by a Big Four firm.",
    "publishedAt": "2018-07-25T08:24:28.000Z",
    "title": "PwC Switzerland to Audit and Examine Tezos' Finances and Operations – CoinSpeaker",
    "url": "https://cryptocontrol.io/r/api/article/5b583462c4be0b000fce9263",
    "source": {
    "_id": "5b4b5794c831fd000f6b5152",
    "name": "CoinSpeaker",
    "url": "https://www.coinspeaker.com/"
},
    "sourceDomain": "coinspeaker.com",
    "thumbnail": "https://cryptocontrol.io/r/thumbnail/5b582ea4c4be0b000fce673f",
    "originalImageUrl": null
},
...
]*/