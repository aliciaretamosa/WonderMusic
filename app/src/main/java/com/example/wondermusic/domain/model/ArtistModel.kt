package com.example.wondermusic.domain.model

data class ArtistModel (
    val id: String,
    val name: String,
    val photoUrl: String,
    val photoHeight: Int,
    val photoWidth: Int,
    //val genres: List<String>,
    val popularity: Int
)