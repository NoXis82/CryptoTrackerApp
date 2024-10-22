package com.noxis.crypto.presentation.event

import com.noxis.common_core.domain.util.NetworkError

sealed interface CoinListEvent {
    data class Error(val error: NetworkError): CoinListEvent
}
