package co.zsmb.rainbowcake.ninetysixpoems.di

import co.zsmb.rainbowcake.dagger.RainbowCakeComponent
import co.zsmb.rainbowcake.dagger.RainbowCakeModule
import co.zsmb.rainbowcake.ninetysixpoems.data.disk.room.DiskModule
import co.zsmb.rainbowcake.ninetysixpoems.data.network.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        RainbowCakeModule::class,
        ApplicationModule::class,
        ViewModelModule::class,
        NetworkModule::class,
        DiskModule::class
    ]
)
interface AppComponent : RainbowCakeComponent
