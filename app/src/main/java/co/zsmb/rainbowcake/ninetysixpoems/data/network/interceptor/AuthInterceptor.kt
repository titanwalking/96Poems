package co.zsmb.rainbowcake.ninetysixpoems.data.network.interceptor

import co.zsmb.rainbowcake.ninetysixpoems.BuildConfig
import okhttp3.HttpUrl

class AuthInterceptor : UrlInterceptor() {
    override fun HttpUrl.Builder.update(url: HttpUrl) {
        addQueryParameter("api-key", BuildConfig.GUARDIAN_API_KEY)
    }
}
