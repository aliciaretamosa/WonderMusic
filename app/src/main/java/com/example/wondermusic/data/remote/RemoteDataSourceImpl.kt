package com.example.wondermusic.data.remote

import android.util.Log
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.SearchDto

class RemoteDataSourceImpl(
    private val artistApi: ArtistApi
): RemoteDataSource {
    override suspend fun getArtistList(): List<ArtistDto> {
       Log.w("Test", "${artistApi.getArtistList().artists.size}")
        Log.w("Test", "hola")
        return  artistApi.getArtistList().artists
    }
}