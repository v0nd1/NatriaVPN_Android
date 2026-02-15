package com.natria.vpn.data.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.natria.vpn.StartConstants
import com.natria.vpn.StartConstants.USER_SETTINGS
import com.natria.vpn.data.local.repository.LocalUserManger
import com.natria.vpn.ui.nav.Screen
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserMangerImpl @Inject constructor(
    private val context: Context
) : LocalUserManger {

    override suspend fun saveStartScreen(screen: String) {
        context.dataStore.edit { settings ->
            settings[PreferenceKeys.START_SCREEN] = screen
        }
    }
    override fun readStartScreen(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PreferenceKeys.START_SCREEN] ?: Screen.Main.route
        }
    }
}

private val readOnlyProperty = preferencesDataStore(name = USER_SETTINGS)

val Context.dataStore: DataStore<Preferences> by readOnlyProperty

private object PreferenceKeys {
    val START_SCREEN = stringPreferencesKey(StartConstants.START_SCREEN)
}
