package com.natria.vpn.ui.screens.main

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Cable
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.CalendarViewDay
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.CheckBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.natria.vpn.ui.DpConstants.betweenSpacer
import com.natria.vpn.ui.DpConstants.borderStroke
import com.natria.vpn.ui.DpConstants.cornerShape
import com.natria.vpn.ui.DpConstants.defaultSpacer
import com.natria.vpn.ui.DpConstants.extraLargeSpacer
import com.natria.vpn.ui.components.VpnConnectionButton
import com.natria.vpn.ui.theme.DarkBlue
import com.natria.vpn.ui.theme.DarkBlue2
import com.natria.vpn.ui.theme.DarkBlue3
import com.natria.vpn.ui.theme.DarkGreen
import com.natria.vpn.ui.theme.DarkRed
import com.natria.vpn.ui.theme.DarkYellow
import com.natria.vpn.ui.theme.Gray
import com.natria.vpn.ui.theme.Green
import com.natria.vpn.ui.theme.Lazurit
import com.natria.vpn.ui.theme.MPlus
import com.natria.vpn.ui.theme.Pink
import com.natria.vpn.ui.theme.Yellow

@Composable
fun MainScreen(

) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(DarkBlue)
    ) {
        Spacer(Modifier.height(extraLargeSpacer))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxWidth()
        ) {
            VpnConnectionButton()
        }
        Spacer(Modifier.height(betweenSpacer))
        Column(
            modifier = Modifier
                .padding(horizontal = defaultSpacer)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .background(DarkBlue3, RoundedCornerShape(cornerShape))
                    .border(BorderStroke(borderStroke, Gray), RoundedCornerShape(cornerShape))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 10.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .padding(vertical = 10.dp)
                                .background(DarkGreen, CircleShape)
                                .border(BorderStroke(borderStroke, Green), CircleShape)
                                .size(30.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Filled.Check,
                                contentDescription = null,
                                tint = Green,
                                modifier = Modifier
                                    .size(15.dp)
                            )
                        }
                        Spacer(Modifier.width(10.dp))
                        Column {
                            Text(
                                text = "user_XXXXXXXXX",
                                fontFamily = MPlus,
                                fontSize = 18.sp,
                                lineHeight = 16.sp,
                                fontWeight = FontWeight.ExtraBold,
                                color = Color.White
                            )
                            Text(
                                text = "Истекает через 20 дней",
                                fontFamily = MPlus,
                                fontSize = 12.sp,
                                lineHeight = 10.sp,
                                fontWeight = FontWeight.Bold,
                                color = Gray
                            )
                        }
                    }
                    Spacer(Modifier.height(15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(DarkBlue2, RoundedCornerShape(10.dp))
                                .border(BorderStroke(0.5.dp, Lazurit), RoundedCornerShape(10.dp))
                                .height(70.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.AccountBox,
                                        contentDescription = null,
                                        tint = Lazurit,
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        text = "Имя пользователя",
                                        fontFamily = MPlus,
                                        fontSize = 12.sp,
                                        lineHeight = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray
                                    )
                                }
                                Text(
                                    text = "user_XXXXXXXXX",
                                    fontFamily = MPlus,
                                    fontSize = 14.sp,
                                    lineHeight = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(DarkGreen, RoundedCornerShape(10.dp))
                                .border(BorderStroke(0.5.dp, Green), RoundedCornerShape(10.dp))
                                .height(70.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.CheckBox,
                                        contentDescription = null,
                                        tint = Green,
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        text = "Статус",
                                        fontFamily = MPlus,
                                        fontSize = 12.sp,
                                        lineHeight = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray
                                    )
                                }
                                Text(
                                    text = "Активна",
                                    fontFamily = MPlus,
                                    fontSize = 14.sp,
                                    lineHeight = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(DarkRed, RoundedCornerShape(10.dp))
                                .border(BorderStroke(0.5.dp, Pink), RoundedCornerShape(10.dp))
                                .height(70.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.CalendarMonth,
                                        contentDescription = null,
                                        tint = Pink,
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        text = "Истекает",
                                        fontFamily = MPlus,
                                        fontSize = 12.sp,
                                        lineHeight = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray
                                    )
                                }
                                Text(
                                    text = "4 марта, 2026",
                                    fontFamily = MPlus,
                                    fontSize = 14.sp,
                                    lineHeight = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                        Spacer(Modifier.width(10.dp))
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .background(DarkYellow, RoundedCornerShape(10.dp))
                                .border(BorderStroke(0.5.dp, Yellow), RoundedCornerShape(10.dp))
                                .height(70.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(15.dp)
                                    .fillMaxHeight(),
                                verticalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row(
                                    verticalAlignment = Alignment.CenterVertically
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.Cable,
                                        contentDescription = null,
                                        tint = Yellow,
                                        modifier = Modifier.size(15.dp)
                                    )
                                    Spacer(Modifier.width(5.dp))
                                    Text(
                                        text = "Трафик",
                                        fontFamily = MPlus,
                                        fontSize = 12.sp,
                                        lineHeight = 10.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Gray
                                    )
                                }
                                Text(
                                    text = "33.61 GiB / ∞",
                                    fontFamily = MPlus,
                                    fontSize = 14.sp,
                                    lineHeight = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = Color.White
                                )
                            }
                        }
                    }
                }

            }

        }

    }
}