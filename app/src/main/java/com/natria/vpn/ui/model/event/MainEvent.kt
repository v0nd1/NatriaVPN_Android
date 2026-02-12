package com.natria.vpn.ui.model.event

import com.natria.vpn.ui.model.MainState

sealed interface MainEvent {
    data class ChangeShowTopBar(val isShowTopBar: Boolean) : MainEvent
}