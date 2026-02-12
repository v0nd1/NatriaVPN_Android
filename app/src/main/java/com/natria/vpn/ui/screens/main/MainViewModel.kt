package com.natria.vpn.ui.screens.main

import androidx.lifecycle.ViewModel
import com.natria.vpn.ui.model.MainState
import com.natria.vpn.ui.model.event.MainEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject



@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {
    private val _state = MutableStateFlow(MainState())
    val state: MutableStateFlow<MainState> get() = _state

    fun onEvent(
        event: MainEvent
    ) {
        when (event) {
            is MainEvent.ChangeShowTopBar -> {
                _state.update {
                    it.copy(
                        isShowTopBar = event.isShowTopBar
                    )
                }
            }
        }

    }
}