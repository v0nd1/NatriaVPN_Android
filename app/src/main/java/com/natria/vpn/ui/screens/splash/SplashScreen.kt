package com.natria.vpn.ui.screens.splash

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.natria.vpn.R
import com.natria.vpn.ui.components.splash.AnimatedBrandText
import com.natria.vpn.ui.components.splash.AnimatedLogo
import com.natria.vpn.ui.components.splash.SplashBackground
import com.natria.vpn.ui.nav.Screen
import com.natria.vpn.ui.theme.DarkBlue
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

object SplashConstants {
    const val TOTAL_DURATION_MS = 1500L
    const val ANIMATION_DURATION_MS = 600
    const val HOLD_DURATION_MS = 900L // TOTAL - ANIMATION

    const val LOGO_INITIAL_SCALE = 0.85f
    const val LOGO_PEAK_SCALE = 1.12f
    const val LOGO_PEAK_POINT = 0.55f
    const val LOGO_FINAL_SCALE = 1.0f

    const val TEXT_INITIAL_OFFSET_DP = 40f
    const val TEXT_INITIAL_SCALE = 0.88f
    const val TEXT_PEAK_SCALE = 1.08f
    const val TEXT_PEAK_POINT = 0.6f
    const val TEXT_FINAL_SCALE = 1.0f

    val LOGO_SIZE = 140.dp
    val BACKGROUND_SIZE = 240.dp
    val TEXT_PADDING_TOP = 10.dp
    val TEXT_FONT_SIZE = 30.sp
    val TEXT_LETTER_SPACING = 1.5.sp
}

object SplashAnimationSpec {
    val logoSpec = tween<Float>(
        durationMillis = SplashConstants.ANIMATION_DURATION_MS,
        easing = LinearOutSlowInEasing
    )

    val textSpec = tween<Float>(
        durationMillis = SplashConstants.ANIMATION_DURATION_MS,
        easing = FastOutSlowInEasing
    )
}


@Composable
@Preview(showBackground = true)
private fun SplashScreenPreview() {
    SplashContent(
        progress = 1f,
        brandName = stringResource(R.string.natriavpn)
    )
}

@Composable
@Preview(showBackground = true)
private fun SplashScreenPreview_Animating() {
    var progress by remember { mutableStateOf(0.3f) }
    LaunchedEffect(Unit) {
        while (true) {
            progress = (progress + 0.02f).coerceIn(0f, 1f)
            delay(30)
        }
    }
    SplashContent(progress = progress, brandName = stringResource(R.string.natriavpn))
}


@Composable
fun SplashScreen(
    navController: NavController,
    viewModel: SplashViewModel,
    modifier: Modifier = Modifier,
    brandName: String = stringResource(R.string.natriavpn),
    onNavigationComplete: (() -> Unit)? = null
) {
    val startScreen by viewModel.startScreen.collectAsState()
    val animationProgress = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        launch {
            animationProgress.animateTo(
                targetValue = 1f,
                animationSpec = SplashAnimationSpec.logoSpec
            )
        }

        delay(SplashConstants.HOLD_DURATION_MS)
        navController.navigate(startScreen) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
        onNavigationComplete?.invoke()
    }

    SplashContent(
        progress = animationProgress.value,
        brandName = brandName,
        modifier = modifier
    )
}

@Composable
private fun SplashContent(
    progress: Float,
    brandName: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(DarkBlue),
        contentAlignment = Alignment.Center
    ) {
        SplashBackground(progress = progress)

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 24.dp)
        ) {
            AnimatedLogo(progress = progress)
            AnimatedBrandText(progress = progress, text = brandName)
        }
    }
}
