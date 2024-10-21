package com.noxis.cryptotrackerapp.di

import com.noxis.common_core.data.network.AppConfigSource
import com.noxis.common_core.data.network.HttpClientFactory
import com.noxis.crypto.data.network.RemoteCoinDataSource
import com.noxis.crypto.domain.CoinDataSource
import com.noxis.crypto.presentation.viewmodels.CoinListViewModel
import com.noxis.cryptotrackerapp.BuildConfig
import io.ktor.client.engine.cio.CIO
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val appModule = module {
    single { HttpClientFactory.create(CIO.create()) }
    single { AppConfigSource(baseUrl = BuildConfig.BASE_URL) }
    singleOf(::RemoteCoinDataSource).bind<CoinDataSource>()
    viewModelOf(::CoinListViewModel)
}