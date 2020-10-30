package co.zsmb.rainbowcake.ninetysixpoems.data.disk.datastore

import android.content.Context
import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import androidx.datastore.preferences.createDataStore
import co.zsmb.rainbowcake.ninetysixpoems.NinetySixPoemsApplication

//
// Created by alican.korkmaz on 30.10.2020.
//
class CommonDataStoreImpl : CommonDataStore {
    private var preferencesDataStore: DataStore<Preferences>? = null
    private var context: Context = NinetySixPoemsApplication.appInstance().applicationContext

    override fun getCommonPreferencesDataStore(): DataStore<Preferences> {
        if (preferencesDataStore == null) preferencesDataStore = context.createDataStore("common")
        return preferencesDataStore!!
    }
}