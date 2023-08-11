package com.example.wondermusic.data.remote.dto

import com.squareup.moshi.Json

data class ArtistDto (
    @Json (name = "id") val id: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "images") val images: List<ImagesDto>,
    @Json(name = "followers") val followers: FollowersDto,
    @Json(name = "genres") val genres: List<String>,

    )