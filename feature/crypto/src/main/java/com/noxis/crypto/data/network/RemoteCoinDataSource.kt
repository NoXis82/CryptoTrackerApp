package com.noxis.crypto.data.network

import com.noxis.common_core.data.network.AppConfigSource
import com.noxis.common_core.data.network.constructUrl
import com.noxis.common_core.data.network.safeCall
import com.noxis.common_core.domain.util.NetworkError
import com.noxis.common_core.domain.util.Result
import com.noxis.common_core.domain.util.map
import com.noxis.crypto.data.dto.CoinHistoryDto
import com.noxis.crypto.data.dto.CoinsResponseDto
import com.noxis.crypto.data.mappers.toCoin
import com.noxis.crypto.data.mappers.toCoinPrice
import com.noxis.crypto.domain.CoinDataSource
import com.noxis.crypto.domain.models.Coin
import com.noxis.crypto.domain.models.CoinPrice
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import java.time.ZoneId
import java.time.ZonedDateTime

class RemoteCoinDataSource(
    private val httpClient: HttpClient,
    private val appConfigSource: AppConfigSource
): CoinDataSource {

    override suspend fun getCoins(): Result<List<Coin>, NetworkError> {
        return safeCall<CoinsResponseDto> {
            httpClient.get(
                urlString = constructUrl("/assets", appConfigSource)
            )
        }.map { response ->
            response.data.map { it.toCoin() }
        }
    }

    override suspend fun getCoinHistory(
        coinId: String,
        start: ZonedDateTime,
        end: ZonedDateTime
    ): Result<List<CoinPrice>, NetworkError> {
        val startMillis = start
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()
        val endMillis = end
            .withZoneSameInstant(ZoneId.of("UTC"))
            .toInstant()
            .toEpochMilli()

        return safeCall<CoinHistoryDto> {
            httpClient.get(
                urlString = constructUrl("/assets/$coinId/history", appConfigSource)
            ) {
                parameter("interval", "h6")
                parameter("start", startMillis)
                parameter("end", endMillis)
            }
        }.map { response ->
         response.data.map { it.toCoinPrice() }
        }
    }
}