package com.natria.vpn.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.natria.vpn.R

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.5.sp
    )
)

val MPlus = FontFamily(
    Font(R.font.mplus_regular, FontWeight.Normal),
    Font(R.font.mplus_bold, FontWeight.Bold),
    Font(R.font.mplus_light, FontWeight.Light),
    Font(R.font.mplus_extrabold, FontWeight.ExtraBold),
    Font(R.font.mplus_medium, FontWeight.Medium),
    Font(R.font.mplus_thin, FontWeight.Thin)

)