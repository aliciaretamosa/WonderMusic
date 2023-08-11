package com.example.wondermusic.data.mappers

import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.FollowersLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.model.FollowersModel
import com.example.wondermusic.domain.model.ImagesModel


fun ArtistDto.toArtistModel() = ArtistModel(
    id = id ?: "",
    name = name ?: "",
    images =  ImagesModel(images[0].height,images[0].url,images[0].width),
    followers = FollowersModel(followers.total),
    genres = genres,
    favorite = false
)

fun ArtistDto.toArtistLocal() = ArtistLocal(
    id = id ?: "",
    name = name ?: "",
    image = ImagesLocal(images[0].height,images[0].url,images[0].width),
    followers = FollowersLocal(followers.total),
    genres = genres,
    favorite = false
)

fun ArtistLocal.toArtistModel() = ArtistModel(
    id = id,
    name = name,
    images = ImagesModel(image.height,image.url,image.width),
    followers = FollowersModel(followers.total),
    genres = genres,
    favorite = favorite


)

fun ArtistDto.toArtistModelConstructorWithoutName() = ArtistModel(
    id = id ?: "",
    name = name ?: "",
    images = ((images[0] ?: ImagesModel(0,"",0)) as ImagesModel),
    followers = FollowersModel(followers.total),
    genres = genres,
    favorite = false
)