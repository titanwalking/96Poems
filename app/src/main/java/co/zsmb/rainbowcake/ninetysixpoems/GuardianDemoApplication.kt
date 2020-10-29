package co.zsmb.rainbowcake.ninetysixpoems

import co.zsmb.rainbowcake.config.Loggers
import co.zsmb.rainbowcake.config.rainbowCake
import co.zsmb.rainbowcake.dagger.RainbowCakeApplication
import co.zsmb.rainbowcake.ninetysixpoems.di.AppComponent
import co.zsmb.rainbowcake.ninetysixpoems.di.ApplicationModule
import co.zsmb.rainbowcake.ninetysixpoems.di.DaggerAppComponent
import co.zsmb.rainbowcake.timber.TIMBER
import timber.log.Timber

class GuardianDemoApplication : RainbowCakeApplication() {

    override lateinit var injector: AppComponent

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
    }

}
