package com.natria.vpn.data.local.usecase

import com.natria.vpn.data.local.repository.LocalUserManger
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

data class StartScreenUseCases(
    val readStartScreen: ReadStartScreen,
    val saveStartScreen: SaveStartScreen
)

class ReadStartScreen @Inject constructor(
    private val localUserManger: LocalUserManger
) {
    operator fun invoke(): Flow<String> {
        return localUserManger.readStartScreen()
    }
}

class SaveStartScreen @Inject constructor(
    private val localUserManger: LocalUserManger
) {
    suspend operator fun invoke(screen: String) {
        localUserManger.saveStartScreen(screen)
    }
}
