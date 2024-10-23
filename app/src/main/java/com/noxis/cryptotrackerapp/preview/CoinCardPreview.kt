package com.noxis.cryptotrackerapp.coincardpreview

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.noxis.crypto.domain.models.Coin
import com.noxis.crypto.presentation.components.coin_list.CoinCard
import com.noxis.crypto.presentation.util.toCoinUi
import com.noxis.cryptotrackerapp.ui.theme.CryptoTrackerAppTheme

@PreviewLightDark
@Composable
private fun CoinCardPreview() {
    CryptoTrackerAppTheme {
        CoinCard(
            coinUi = previewCoin,
            onClick = { /*TODO*/ },
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )
        )
    }
}

internal val previewCoin = Coin(
    id = "bitcoin",
    rank = 1,
    name = "Bitcoin",
    symbol = "BTC",
    marketCapUsd = 1241273958896.75,
    priceUsd = 62828.15,
    changePercent24Hr = -0.1
).toCoinUi()
