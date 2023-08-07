package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto

interface RemoteDataSource {
    suspend fun getArtistList(): List<ArtistDto>
}