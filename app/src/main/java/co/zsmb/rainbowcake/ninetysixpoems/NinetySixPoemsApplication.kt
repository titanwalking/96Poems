package co.zsmb.rainbowcake.ninetysixpoems

import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.ninetysixpoems.di.AppComponent
import co.zsmb.rainbowcake.ninetysixpoems.di.ApplicationModule
import co.zsmb.rainbowcake.ninetysixpoems.di.DaggerAppComponent
import co.zsmb.rainbowcake.timber.TIMBER
import com.google.firebase.analytics.FirebaseAnalytics
import timber.log.Timber

class NinetySixPoemsApplication : RainbowCakeApplication() {

    override lateinit var injector: AppComponent

    private lateinit var firebaseAnalytics: FirebaseAnalytics

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
    }

}
