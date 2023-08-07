package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class ArtistsDto (
    @Json(name = "artists") val artists: List<ArtistDto>,
)