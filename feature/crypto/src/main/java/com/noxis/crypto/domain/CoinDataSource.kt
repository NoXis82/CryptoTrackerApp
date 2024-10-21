package com.noxis.crypto.domain

import com.noxis.common_core.domain.util.NetworkError
import com.noxis.common_core.domain.util.Result
import com.noxis.crypto.domain.models.Coin

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
}