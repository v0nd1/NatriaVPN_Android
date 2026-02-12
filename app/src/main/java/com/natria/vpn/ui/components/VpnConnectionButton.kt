package com.natria.vpn.ui.components

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natria.vpn.ui.theme.DarkBlue2
import com.natria.vpn.ui.theme.Lazurit
import com.natria.vpn.ui.theme.MPlus
import kotlinx.coroutines.delay

@Composable
fun VpnConnectionButton() {
    var isConnected by remember { mutableStateOf(false) }
    var connectionStartTime by remember { mutableStateOf<Long?>(null) }
    var elapsedTime by remember { mutableStateOf(0L) }
    val interactionSource = remember { MutableInteractionSource() }
    val isPressed by interactionSource.collectIsPressedAsState()
    val context = LocalContext.current
    var showLoader by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (isPressed) 0.95f else 1f,
        animationSpec = tween(durationMillis = 150),
        label = "scale"
    )

    LaunchedEffect(isConnected) {
        if (isConnected) {
            connectionStartTime = System.currentTimeMillis()
            while (true) {
                delay(1000L)
                connectionStartTime?.let {
                    elapsedTime = System.currentTimeMillis() - it
                }

            }
        } else {
            elapsedTime = 0L
        }
    }

     LaunchedEffect(isConnected) {
         if (isConnected) {
             showLoader = true
             delay(1500L)
             showLoader = false
         } else {
             showLoader = false
         }

     }

    val formattedTime = remember(elapsedTime) {
        val totalSeconds = elapsedTime / 1000
        val hours = totalSeconds / 3600
        val minutes = (totalSeconds % 3600) / 60
        val seconds = totalSeconds % 60
        String.format("%02d:%02d:%02d", hours, minutes, seconds)
    }

    val infiniteTransition = rememberInfiniteTransition(label = "loaderTransition")
    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(1200, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "rotation"
    )

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = if (isConnected) "Нажмите на кнопку,\nчтобы отключить VPN"
                else "Нажмите на кнопку,\nчтобы включить VPN",
            lineHeight = 18.sp,
            color = Color.White,
            fontFamily = MPlus,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Spacer(Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(180.dp)
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null
                    ) {
                        if (isConnected) {
                            isConnected = false
                        } else {
                            isConnected = true
                        }
                    }
                    .scale(scale),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(180.dp)
                        .border(
                            BorderStroke(2.dp, if (showLoader) Color.Transparent else Lazurit),
                            CircleShape
                        )
                        .background(DarkBlue2, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    if (isConnected) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.PowerSettingsNew,
                                contentDescription = "Power",
                                tint = Color.White,
                                modifier = Modifier.size(30.dp)
                            )
                            Text(
                                text = "ПОДКЛЮЧЕН",
                                color = Color.Gray,
                                fontFamily = MPlus,
                                lineHeight = 10.sp,
                                fontWeight = FontWeight.Bold,
                                fontSize = 12.sp,
                                style = MaterialTheme.typography.bodyMedium,
                                modifier = Modifier.padding(top = 12.dp)
                            )
                            Text(
                                text = formattedTime,
                                color = Lazurit,
                                fontFamily = MPlus,
                                lineHeight = 10.sp,
                                fontSize = 12.sp,
                            )
                        }

                    } else {
                        Icon(
                            imageVector = Icons.Filled.PowerSettingsNew,
                            contentDescription = "Power",
                            tint = Color.White,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                }

                if (showLoader) {
                    Box(
                        modifier = Modifier
                            .size(180.dp)
                            .drawWithContent {
                                val strokeWidth = 3.dp.toPx()
                                val radius = size.minDimension / 2 - strokeWidth / 2
                                val center = Offset(size.width / 2, size.height / 2)

                                drawArc(
                                    color = Lazurit,
                                    startAngle = rotation - 30f,
                                    sweepAngle = 60f,
                                    useCenter = false,
                                    topLeft = Offset(center.x - radius, center.y - radius),
                                    size = Size(radius * 2, radius * 2),
                                    style = Stroke(
                                        width = strokeWidth,
                                        cap = StrokeCap.Round
                                    )
                                )
                                drawContent()
                            }
                    )
                }
            }


        }
    }

}
