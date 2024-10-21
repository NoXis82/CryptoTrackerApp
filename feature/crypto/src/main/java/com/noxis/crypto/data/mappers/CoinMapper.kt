package com.noxis.crypto.data.mappers

import com.noxis.crypto.data.dto.CoinDto
import com.noxis.crypto.domain.models.Coin

fun CoinDto.toCoin(): Coin {
    return Coin(
        id = id,
        rank = rank,
        name = name,
        symbol = symbol,
        marketCapUsd = marketCapUsd,
        priceUsd = priceUsd,
        changePercent24Hr = changePercent24Hr
    )
}
