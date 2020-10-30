package co.zsmb.rainbowcake.ninetysixpoems

import androidx.datastore.DataStore
import androidx.datastore.preferences.Preferences
import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.ninetysixpoems.data.disk.datastore.CommonDataStoreImpl
import co.zsmb.rainbowcake.ninetysixpoems.di.AppComponent
import co.zsmb.rainbowcake.ninetysixpoems.di.ApplicationModule
import co.zsmb.rainbowcake.ninetysixpoems.di.DaggerAppComponent
import co.zsmb.rainbowcake.timber.TIMBER
import com.google.firebase.analytics.FirebaseAnalytics
import timber.log.Timber

class NinetySixPoemsApplication : RainbowCakeApplication() {

    companion object {
        private lateinit var instance: NinetySixPoemsApplication

        @JvmStatic
        fun appInstance(): NinetySixPoemsApplication {
            return instance
        }
    }

    init {
        instance = this
    }

    override lateinit var injector: AppComponent

    private lateinit var firebaseAnalytics: FirebaseAnalytics

    private lateinit var dataStore: DataStore<Preferences>

    override fun setupInjector() {
        injector = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()

        rainbowCake {
            logger = Loggers.TIMBER
            isDebug = BuildConfig.DEBUG
        }

        Timber.plant(Timber.DebugTree())

        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        dataStore = CommonDataStoreImpl().getCommonPreferencesDataStore()
    }

    fun dataStore(): DataStore<Preferences> = dataStore
}
