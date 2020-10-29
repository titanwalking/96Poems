package co.zsmb.rainbowcake.ninetysixpoems.data.network

import co.zsmb.rainbowcake.ninetysixpoems.data.network.model.NewsResponseWrapper
import co.zsmb.rainbowcake.ninetysixpoems.data.network.model.SearchResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Path

interface GuardianApi {
    @GET("search")
    suspend fun getNews(): SearchResponseWrapper

    @GET("{id}")
    suspend fun getNewsById(@Path("id", encoded = true) id: String): NewsResponseWrapper
}
