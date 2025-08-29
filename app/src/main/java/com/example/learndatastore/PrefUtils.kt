package com.example.learndatastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class PrefUtils(val context: Context) {
    private val Context.dataStore by preferencesDataStore("local")
    suspend fun saveString(key: String, value: String){
        context.dataStore.edit {
            it[stringPreferencesKey(key)] = value
        }
    }
    suspend fun getString(key: String): String? {
        return context.dataStore.data.map {
            it[stringPreferencesKey(key)]
        }.first()
    }
    suspend fun getInt(key: String): Int? {
        return context.dataStore.data.map {
            it[intPreferencesKey(key)]
        }.first()
    }

    suspend fun saveInt(key: String, value: Int) {
        context.dataStore.edit {
            it[intPreferencesKey(key)] = value
        }
    }
}