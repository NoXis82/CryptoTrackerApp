package com.noxis.cryptotrackerapp.preview

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.noxis.crypto.presentation.components.PriceChange
import com.noxis.crypto.presentation.models.DisplayableNumber
import com.noxis.cryptotrackerapp.ui.theme.CryptoTrackerAppTheme

@PreviewLightDark
@Composable
private fun PriceChangePreview1() {
    CryptoTrackerAppTheme {
        PriceChange(
            change = DisplayableNumber(
                value = 2.43,
                formatted = "2.43"
            )
        )
    }
}

@PreviewLightDark
@Composable
private fun PriceChangePreview2() {
    CryptoTrackerAppTheme {
        PriceChange(
            change = DisplayableNumber(
                value = -2.43,
                formatted = "-2.43"
            )
        )
    }
}
