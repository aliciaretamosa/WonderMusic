package com.example.wondermusic.domain.model

data class ArtistModel (
    val id: String,
    val name: String,
    val images: ImagesModel,
    val followers: FollowersModel,
    val genres: List<String>?,
    val favorite: Boolean
)