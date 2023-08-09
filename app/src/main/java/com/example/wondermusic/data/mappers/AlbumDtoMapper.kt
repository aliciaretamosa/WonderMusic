package com.example.wondermusic.data.mappers

import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.data.remote.dto.AlbumDto
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ImagesModel


fun AlbumDto.toAlbumModel() = AlbumModel(
    id = id ?: "",
    name = name ?: "",
    images =  ImagesModel(images[0].height,images[0].url,images[0].width)
)

fun AlbumDto.toAlbumLocal() = AlbumLocal(
    albumId = id ?: "",
    name = name ?: "",
    image = ImagesLocal(images[0].height,images[0].url,images[0].width),
    artistId = ""
)

fun AlbumLocal.toAlbumModel() = AlbumModel(
    id = albumId,
    name = name,
    images = ImagesModel(image.height,image.url,image.width),
)


fun AlbumDto.toAlbumModelConstructorWithoutName() = AlbumModel(
    id = id,
    name = name,
    images = ImagesModel(0,"",0),
)