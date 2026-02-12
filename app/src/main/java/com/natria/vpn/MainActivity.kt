package com.natria.vpn

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.navigation.compose.rememberNavController
import com.natria.vpn.ui.theme.NatriaVPNTheme
import dagger.hilt.android.AndroidEntryPoint
import com.natria.vpn.ui.nav.NavGraph
import com.natria.vpn.ui.screens.main.MainViewModel
import com.natria.vpn.ui.screens.splash.SplashViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val splashViewModel: SplashViewModel by viewModels()
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NatriaVPNTheme {
                NavGraph(
                    navController = rememberNavController(),
                    splashViewModel = splashViewModel,
                    mainViewModel = mainViewModel
                )
            }
        }
    }
}
