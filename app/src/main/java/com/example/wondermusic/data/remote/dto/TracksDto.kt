package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class TracksDto (
    @Json(name = "tracks") val tracks: List<TrackDto>
    )