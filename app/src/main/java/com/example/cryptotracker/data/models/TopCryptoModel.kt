package com.example.cryptotracker.data.models


data class TopCryptoModel(
    val `data`: List<Data>
)

data class Data(
    val name: String,
    val quote: Quote,
    val symbol: String
)

data class Quote(
    val USD: USD
)

data class USD(
    val percent_change_1h: String,
    val percent_change_24h: String,
    val percent_change_7d: String,
    val price: String
)


/*
{
    "status": {
        "timestamp": "2020-03-09T04:24:40.913Z",
        "error_code": 0,
        "error_message": null,
        "elapsed": 13,
        "credit_count": 1,
        "notice": null
    },
    "data": [
        {
            "id": 1,
            "name": "Bitcoin",
            "symbol": "BTC",
            "slug": "bitcoin",
            "num_market_pairs": 7791,
            "date_added": "2013-04-28T00:00:00.000Z",
            "tags": [
                "mineable"
            ],
            "max_supply": 21000000,
            "circulating_supply": 18261075,
            "total_supply": 18261075,
            "platform": null,
            "cmc_rank": 1,
            "last_updated": "2020-03-09T04:23:38.000Z",
            "quote": {
                "USD": {
                    "price": 7943.85934921,
                    "volume_24h": 41295306076.9716,
                    "percent_change_1h": -1.76835,
                    "percent_change_24h": -9.31284,
                    "percent_change_7d": -7.82344,
                    "market_cap": 145063411365.375,
                    "last_updated": "2020-03-09T04:23:38.000Z"
                }
            }
        }
    ]
}
 */