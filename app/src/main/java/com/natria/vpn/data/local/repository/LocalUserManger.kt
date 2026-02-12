package com.natria.vpn.data.local.repository

import kotlinx.coroutines.flow.Flow

interface LocalUserManger {

    suspend fun saveStartScreen(screen: String)

    fun readStartScreen(): Flow<String>
}