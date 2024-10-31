package com.noxis.cryptotrackerapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.noxis.common_core.presentation.util.ObserveAsEvents
import com.noxis.common_core.presentation.util.toString
import com.noxis.crypto.presentation.components.coin_detail.CoinDetailScreen
import com.noxis.crypto.presentation.components.coin_list.CoinListScreen
import com.noxis.crypto.presentation.event.CoinListEvent
import com.noxis.crypto.presentation.viewmodels.CoinListViewModel
import com.noxis.cryptotrackerapp.navigation.AdaptiveCoinListDetailPane
import com.noxis.cryptotrackerapp.ui.theme.CryptoTrackerAppTheme
import org.koin.androidx.compose.koinViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CryptoTrackerAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    AdaptiveCoinListDetailPane(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
