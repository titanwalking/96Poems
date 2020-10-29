package co.zsmb.rainbowcake.ninetysixpoems.data.network

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [NetworkModule::class]
)
interface NetworkTestComponent {
    fun guardianApi(): GuardianApi
}
