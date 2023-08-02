package com.example.wondermusic.data

import com.example.wondermusic.domain.model.ArtistModel

interface ArtistRepository {
    suspend fun getArtistList(): List<ArtistModel>

    suspend fun getArtistById(id:String): ArtistModel
}