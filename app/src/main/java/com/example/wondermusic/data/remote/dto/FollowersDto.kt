package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class FollowersDto(
    @Json(name = "total") val total: Int,
)