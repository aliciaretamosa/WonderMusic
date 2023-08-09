package com.example.wondermusic.domain.model

import com.example.wondermusic.data.remote.dto.FollowersDto
import com.squareup.moshi.Json

data class ArtistModel (
    val id: String,
    val name: String,
    val images: ImagesModel,
    val followers: FollowersModel,
    val genres: List<String>?,
    val favorite: Boolean
)