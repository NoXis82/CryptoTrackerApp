package com.noxis.cryptotrackerapp.preview

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.noxis.crypto.presentation.components.coin_detail.CoinDetailScreen
import com.noxis.crypto.presentation.state.CoinListState
import com.noxis.cryptotrackerapp.coincardpreview.previewCoin
import com.noxis.cryptotrackerapp.ui.theme.CryptoTrackerAppTheme

@PreviewLightDark
@Composable
private fun CoinDetailScreenPreview() {
    CryptoTrackerAppTheme {
        CoinDetailScreen(
            state = CoinListState(
                selectedCoin = previewCoin,
            ),
            modifier = Modifier.background(
                MaterialTheme.colorScheme.background
            )
        )
    }
}