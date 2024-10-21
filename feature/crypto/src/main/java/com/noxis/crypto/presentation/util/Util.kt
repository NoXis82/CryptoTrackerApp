package com.noxis.crypto.presentation.util

import android.icu.text.NumberFormat
import com.noxis.common_core.presentation.util.getDrawableIdForCoin
import com.noxis.crypto.domain.models.Coin
import com.noxis.crypto.presentation.models.CoinUi
import com.noxis.crypto.presentation.models.DisplayableNumber
import java.util.Locale

fun Double.toDisplayableNumber(): DisplayableNumber {
    val formatter = NumberFormat.getNumberInstance(Locale.getDefault()).apply {
        minimumFractionDigits = 2
        maximumFractionDigits = 2
    }
    return DisplayableNumber(
        value = this,
        formatted = formatter.format(this)
    )
}

fun Coin.toCoinUi(): CoinUi {
    return CoinUi(
        id = id,
        name = name,
        symbol = symbol,
        rank = rank,
        priceUsd = priceUsd.toDisplayableNumber(),
        marketCapUsd = marketCapUsd.toDisplayableNumber(),
        changePercent24Hr = changePercent24Hr.toDisplayableNumber(),
        iconRes = getDrawableIdForCoin(symbol)
    )
}