package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class TrackDto (
    @Json(name = "album") val album: AlbumDto

    )