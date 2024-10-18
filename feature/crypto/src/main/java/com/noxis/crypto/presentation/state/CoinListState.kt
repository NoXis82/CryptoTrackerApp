package com.noxis.crypto.presentation.state

import androidx.compose.runtime.Immutable
import com.noxis.crypto.presentation.models.CoinUi

@Immutable
data class CoinListState(
    val isLoading: Boolean = false,
    val coins: List<CoinUi> = emptyList(),
    val selectedCoin: CoinUi? = null
)
