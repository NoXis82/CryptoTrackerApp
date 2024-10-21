package com.noxis.crypto.presentation.event

import com.noxis.crypto.presentation.models.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick(val coinUi: CoinUi): CoinListAction

}