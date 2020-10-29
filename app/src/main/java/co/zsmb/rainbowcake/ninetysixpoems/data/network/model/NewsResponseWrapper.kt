package co.zsmb.rainbowcake.ninetysixpoems.data.network.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class NewsResponseWrapper(
    val response: NewsResponse
)
