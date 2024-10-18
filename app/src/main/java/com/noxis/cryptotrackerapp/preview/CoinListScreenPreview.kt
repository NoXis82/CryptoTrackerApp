package com.noxis.cryptotrackerapp.preview

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.noxis.crypto.presentation.components.CoinListScreen
import com.noxis.crypto.presentation.state.CoinListState
import com.noxis.cryptotrackerapp.coincardpreview.previewCoin
import com.noxis.cryptotrackerapp.ui.theme.CryptoTrackerAppTheme

@PreviewLightDark
@Composable
private fun CoinListScreenPreview() {
    CryptoTrackerAppTheme {
        CoinListScreen(
            state = CoinListState(
                coins = (1..100).map {
                    previewCoin.copy(id = it.toString())
                }
            ),
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
        )
    }
}
