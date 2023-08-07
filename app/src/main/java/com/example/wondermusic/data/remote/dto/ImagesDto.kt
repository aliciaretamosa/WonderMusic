package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class ImagesDto (
    @Json(name = "height") val height: Int,
    @Json(name = "url") val url: String,
    @Json(name = "width") val width: Int,
)