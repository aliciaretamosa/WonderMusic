package com.example.wondermusic.data.local

import com.example.wondermusic.data.local.model.ArtistLocal

class LocalDataSourceImpl(
    private val artistDao: ArtistDao
): LocalDataSource {
    override suspend fun insertArtistList(artistList: List<ArtistLocal>) = artistDao.insertAll(artistList)

    override suspend fun getArtistList() : List<ArtistLocal> = artistDao.getAll()

    override suspend fun getArtistById(id: String): ArtistLocal = artistDao.getArtistById(id)
}