package com.natria.vpn.ui.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.natria.vpn.data.local.usecase.StartScreenUseCases
import com.natria.vpn.ui.nav.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor (
    private val startScreenUseCases: StartScreenUseCases
) : ViewModel() {
    private val _startScreen = MutableStateFlow(Screen.Main.route)
    val startScreen: StateFlow<String> = _startScreen.asStateFlow()

    init {
        viewModelScope.launch {
            startScreenUseCases.readStartScreen().collect { screen ->
                _startScreen.value = screen
            }
        }
    }

}