package com.natria.vpn.ui.nav

sealed class Screen(
    val route: String
) {

    data object Splash : Screen(
        route = "splash"
    )

    data object Main : Screen(
        route = "main"
    )

    data object Settings : Screen(
        route = "settings"
    )

}