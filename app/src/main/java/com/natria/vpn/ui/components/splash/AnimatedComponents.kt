package com.natria.vpn.ui.components.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.natria.vpn.R
import com.natria.vpn.ui.screens.splash.SplashConstants
import com.natria.vpn.ui.theme.DarkBlue
import com.natria.vpn.ui.theme.MPlus

@Composable
fun SplashBackground(
    progress: Float,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .size(SplashConstants.BACKGROUND_SIZE)
            .background(
                brush = Brush.radialGradient(
                    colors = listOf(
                        DarkBlue.copy(alpha = 0.45f),
                        Color.Transparent
                    )
                ),
                shape = CircleShape
            )
            .alpha(progress * 0.7f)
    )
}

@Composable
fun AnimatedLogo(
    progress: Float,
    modifier: Modifier = Modifier
) {
    val scale = remember(progress) {
        when {
            progress < SplashConstants.LOGO_PEAK_POINT ->
                SplashConstants.LOGO_INITIAL_SCALE + progress * 0.5f
            else ->
                SplashConstants.LOGO_PEAK_SCALE - (progress - SplashConstants.LOGO_PEAK_POINT) * 0.25f
        }.coerceIn(SplashConstants.LOGO_INITIAL_SCALE, SplashConstants.LOGO_PEAK_SCALE)
    }

    Image(
        painter = painterResource(R.drawable.logo),
        contentDescription = "Natria logo",
        modifier = modifier
            .size(SplashConstants.LOGO_SIZE)
            .graphicsLayer(
                alpha = progress,
                scaleX = scale,
                scaleY = scale
            )
    )
}

@Composable
fun AnimatedBrandText(
    progress: Float,
    text: String,
    modifier: Modifier = Modifier
) {
    val offsetY = remember(progress) {
        (1f - progress) * SplashConstants.TEXT_INITIAL_OFFSET_DP * -1
    }

    val scale = remember(progress) {
        when {
            progress < SplashConstants.TEXT_PEAK_POINT ->
                SplashConstants.TEXT_INITIAL_SCALE + progress * 0.3f
            else ->
                SplashConstants.TEXT_PEAK_SCALE - (progress - SplashConstants.TEXT_PEAK_POINT) * 0.2f
        }.coerceIn(SplashConstants.TEXT_INITIAL_SCALE, SplashConstants.TEXT_PEAK_SCALE)
    }

    Text(
        text = text,
        modifier = modifier
            .offset(y = offsetY.dp)
            .graphicsLayer(
                alpha = progress,
                scaleX = scale,
                scaleY = scale
            )
            .padding(top = SplashConstants.TEXT_PADDING_TOP),
        style = TextStyle(
            fontSize = SplashConstants.TEXT_FONT_SIZE,
            fontWeight = FontWeight.Bold,
            fontFamily = MPlus,
            color = Color.White,
            letterSpacing = SplashConstants.TEXT_LETTER_SPACING
        ),
        maxLines = 1,
        overflow = TextOverflow.Clip
    )
}