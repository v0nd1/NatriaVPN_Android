package com.natria.vpn.ui.nav

import android.annotation.SuppressLint
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.natria.vpn.R
import com.natria.vpn.ui.model.event.MainEvent
import com.natria.vpn.ui.screens.main.MainScreen
import com.natria.vpn.ui.screens.main.MainViewModel
import com.natria.vpn.ui.screens.settings.SettingsScreen
import com.natria.vpn.ui.screens.splash.SplashScreen
import com.natria.vpn.ui.screens.splash.SplashViewModel
import com.natria.vpn.ui.theme.MPlus

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavGraph(
    navController: NavHostController,
    splashViewModel: SplashViewModel,
    mainViewModel: MainViewModel
) {

    val mainState by mainViewModel.state.collectAsState()

    Scaffold(
        topBar = {
            if (mainState.isShowTopBar) {
                Column(
                    modifier = Modifier.padding(top = 40.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 15.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(R.drawable.logo),
                                contentDescription = null,
                                tint = Color.Unspecified,
                                modifier = Modifier
                                    .size(50.dp)
                            )
                            Spacer(Modifier.width(10.dp))
                            Text(
                                text = "natriavpn",
                                fontFamily = MPlus,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White

                            )
                        }

                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(20.dp)
                                .clickable {
                                    navController.navigate(Screen.Settings.route)
                                }
                        )

                    }
                }
            }
        }
    ) {
        NavHost(
            navController = navController,
            startDestination = Screen.Splash.route,
            enterTransition = { EnterTransition.None },
            exitTransition = { ExitTransition.None },
            popExitTransition = { ExitTransition.None },
            popEnterTransition = { EnterTransition.None }
        )  {
            composable(route = Screen.Splash.route) {
                mainViewModel.onEvent(MainEvent.ChangeShowTopBar(false))
                SplashScreen(
                    navController = navController,
                    viewModel = splashViewModel
                )
            }

            composable(route = Screen.Main.route) {
                mainViewModel.onEvent(MainEvent.ChangeShowTopBar(true))
                MainScreen()
            }

            composable(route = Screen.Settings.route) {
                mainViewModel.onEvent(MainEvent.ChangeShowTopBar(false))
                SettingsScreen(
                    navController = navController
                )
            }
        }
    }

}