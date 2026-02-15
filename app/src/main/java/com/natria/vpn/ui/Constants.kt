package com.natria.vpn.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

object DpConstants {

    // Spacers
    val extraLargeSpacer: Dp
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 100.dp
                screenHeight in 770..900 -> 120.dp
                else -> 140.dp
            }
        }

    val betweenSpacer: Dp
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 30.dp
                screenHeight in 770..900 -> 40.dp
                else -> 50.dp
            }
        }

    val defaultSpacer: Dp
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 5.dp
                screenHeight in 770..900 -> 15.dp
                else -> 25.dp
            }
        }

    // Other values
    val cornerShape: Dp
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 10.dp
                screenHeight in 770..900 -> 15.dp
                else -> 20.dp
            }
        }

    val borderStroke: Dp
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 0.3.dp
                screenHeight in 770..900 -> 0.5.dp
                else -> 0.8.dp
            }
        }


}

object FontSizeConstants {

    val extraLargeTitleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 30.sp
                screenHeight in 770..900 -> 34.sp
                else -> 38.sp
            }
        }

    val largeTitleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 30.sp
                screenHeight in 770..900 -> 34.sp
                else -> 38.sp
            }
        }

    val bigTitle3FontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 24.sp
                screenHeight in 770..900 -> 28.sp
                else -> 32.sp
            }
        }

    val bigTitle2FontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 20.sp
                screenHeight in 770..900 -> 24.sp
                else -> 28.sp
            }
        }

    val bigTitleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 18.sp
                screenHeight in 770..900 -> 22.sp
                else -> 26.sp
            }
        }

    val titleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 16.sp
                screenHeight in 770..900 -> 20.sp
                else -> 24.sp
            }
        }

    val bigSubtitleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 16.sp
                screenHeight in 770..900 -> 18.sp
                else -> 22.sp
            }
        }

    val subtitleFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 14.sp
                screenHeight in 770..900 -> 16.sp
                else -> 20.sp
            }
        }

    val bodyFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 12.sp
                screenHeight in 770..900 -> 14.sp
                else -> 16.sp
            }
        }

    val minBodyFontSize: TextUnit
        @Composable
        get() {
            val screenHeight = LocalConfiguration.current.screenHeightDp
            return when {
                screenHeight < 770 -> 10.sp
                screenHeight in 770..900 -> 12.sp
                else -> 14.sp
            }
        }
}