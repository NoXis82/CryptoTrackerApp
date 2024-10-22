package com.noxis.crypto.presentation.state

import com.noxis.crypto.presentation.models.CoinUi

sealed interface CoinListAction {

    data class OnCoinClick(val coinUi: CoinUi): CoinListAction

}