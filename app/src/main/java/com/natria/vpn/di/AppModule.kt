package com.natria.vpn.di

import android.app.Application
import com.natria.vpn.data.local.LocalUserMangerImpl
import com.natria.vpn.data.local.repository.LocalUserManger
import com.natria.vpn.data.local.usecase.ReadStartScreen
import com.natria.vpn.data.local.usecase.SaveStartScreen
import com.natria.vpn.data.local.usecase.StartScreenUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManger = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManger
    ): StartScreenUseCases = StartScreenUseCases(
        readStartScreen = ReadStartScreen(localUserManger),
        saveStartScreen = SaveStartScreen(localUserManger)
    )
}
