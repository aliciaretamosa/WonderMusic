package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistDto

interface RemoteDataSource {
    suspend fun getArtistList(): List<ArtistDto>
}