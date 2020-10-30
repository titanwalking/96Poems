package co.zsmb.rainbowcake.ninetysixpoems.data.disk.datastore

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences

//
// Created by alican.korkmaz on 30.10.2020.
//
interface CommonDataStore {
    fun getCommonPreferencesDataStore(): DataStore<Preferences>
}