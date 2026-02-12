package com.natria.vpn.ui.screens.settings

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.natria.vpn.ui.theme.DarkBlue
import com.natria.vpn.ui.theme.DarkBlue2
import com.natria.vpn.ui.theme.Lazurit
import com.natria.vpn.ui.theme.MPlus

@Composable
fun SettingsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = 15.dp)
        ) {
            Spacer(Modifier.height(40.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Настройки",
                    fontFamily = MPlus,
                    fontSize = 26.sp,
                    lineHeight = 10.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = Color.White
                )

                Text(
                    text = "Готово",
                    fontFamily = MPlus,
                    fontSize = 14.sp,
                    lineHeight = 10.sp,
                    color = Lazurit,
                    modifier = Modifier
                        .clickable {
                            navController.popBackStack()
                        }
                )

            }
            Spacer(Modifier.height(40.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBlue2, RoundedCornerShape(10.dp))
                    .wrapContentHeight()
            ) {
                Column {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                            .clickable {},
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Выбор приложения",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(10.dp)
                        )
                    }
                    HorizontalDivider(thickness = 1.dp, color = Lazurit)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                            .clickable {},
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Ручная настройка",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(10.dp)
                        )
                    }
                    HorizontalDivider(thickness = 1.dp, color = Lazurit)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                            .clickable {},
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Сбросить конфигурацию",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                        Text(
                            text = "",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                    }
                    HorizontalDivider(thickness = 1.dp, color = Lazurit)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 10.dp, start = 15.dp, end = 15.dp)
                            .clickable {},
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "Написать в поддержку",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                        Text(
                            text = "",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                    }
                    HorizontalDivider(thickness = 1.dp, color = Lazurit)
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp, bottom = 15.dp, start = 15.dp, end = 15.dp)
                            .clickable {},
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "О приложении",
                            fontFamily = MPlus,
                            fontSize = 16.sp,
                            lineHeight = 10.sp,
                            color = Color.White
                        )
                        Icon(
                            imageVector = Icons.Filled.ArrowForwardIos,
                            contentDescription = null,
                            tint = Color.White,
                            modifier = Modifier
                                .size(10.dp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(DarkBlue2, RoundedCornerShape(10.dp))
                    .wrapContentHeight(),
                contentAlignment = Alignment.CenterStart
            ) {
                Text(
                    text = "\uD83D\uDCA1 Включайте и выключайте VPN только через приложение Natria VPN. Не используйте для этого раздел «Настройки» в Android.",
                    fontFamily = MPlus,
                    fontSize = 14.sp,
                    lineHeight = 16.sp,
                    color = Color.White,
                    modifier = Modifier.padding(15.dp)
                )
            }
        }
    }
}