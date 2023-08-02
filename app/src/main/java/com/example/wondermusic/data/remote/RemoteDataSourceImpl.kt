package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val artistApi: ArtistApi
): RemoteDataSource {
    override suspend fun getArtistList(): List<ArtistDto> =
        artistApi.getArtistList()
}