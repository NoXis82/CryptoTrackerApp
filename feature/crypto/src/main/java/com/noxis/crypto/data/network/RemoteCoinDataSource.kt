package com.noxis.crypto.data.network

import com.noxis.common_core.data.network.safeCall
import com.noxis.common_core.domain.util.NetworkError
import com.noxis.common_core.domain.util.Result
import com.noxis.common_core.domain.util.map
import com.noxis.crypto.data.dto.CoinsResponseDto
import com.noxis.crypto.data.mappers.toCoin
import com.noxis.crypto.domain.CoinDataSource
import com.noxis.crypto.domain.models.Coin
import io.ktor.client.HttpClient
import io.ktor.client.request.get

class RemoteCoinDataSource(
    private val httpClient: HttpClient
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = "" //constructUrl("/assets")
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }
}