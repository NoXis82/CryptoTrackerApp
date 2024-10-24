package com.noxis.crypto.domain

import com.noxis.common_core.domain.util.NetworkError
import com.noxis.common_core.domain.util.Result
import com.noxis.crypto.domain.models.Coin
import com.noxis.crypto.domain.models.CoinPrice
import java.time.ZonedDateTime

interface CoinDataSource {
    suspend fun getCoins(): Result<List<Coin>, NetworkError>
    suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError>
}