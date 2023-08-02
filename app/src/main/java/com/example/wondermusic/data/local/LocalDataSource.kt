package com.example.wondermusic.data.local

import com.example.wondermusic.data.local.model.ArtistLocal

interface LocalDataSource {
     suspend fun insertArtistList(artistList: List<ArtistLocal>)

     suspend fun getArtistList() : List<ArtistLocal>

     suspend fun getArtistById(id: String): ArtistLocal
}