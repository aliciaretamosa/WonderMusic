package com.example.wondermusic.data.mappers

import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.domain.model.ArtistModel

fun ArtistDto.toArtistModel() = ArtistModel(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photoUrl ?: "",
    photoHeight = photoHeight ?: 0,
    photoWidth = photoWidth ?: 0,
    //genres = genres ?: listOf(""),
    popularity = popularity ?: 0
)

fun ArtistDto.toArtistLocal() = ArtistLocal(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photoUrl ?: "",
    photoHeight = photoHeight ?: 0,
    photoWidth = photoWidth ?: 0,
    //genres = genres ?: listOf(""),
    popularity = popularity ?: 0
)

fun ArtistLocal.toArtistModel() = ArtistModel(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photoUrl ?: "",
    photoHeight = photoHeight ?: 0,
    photoWidth = photoWidth ?: 0,
   // genres = genres ?: listOf(""),
    popularity = popularity ?: 0
)

fun ArtistDto.toArtistModelConstructorWithoutName() = ArtistModel(
    id = id ?: "",
    name = name ?: "",
    photoUrl = photoUrl ?: "",
    photoHeight = photoHeight ?: 0,
    photoWidth = photoWidth ?: 0,
    //genres = genres ?: listOf(""),
    popularity = popularity ?: 0
)