package com.example.wondermusic.data.local

import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ArtistLocal

class LocalDataSourceImpl(
    private val artistDao: ArtistDao,
    private val albumDao: AlbumDao
): LocalDataSource {
    override suspend fun insertArtistList(artistList: List<ArtistLocal>) = artistDao.insertAll(artistList)

    override suspend fun insertTopTracksList(tracksList: List<AlbumLocal>) = albumDao.insertAll(tracksList)

    override suspend fun getArtistList() : List<ArtistLocal> = artistDao.getAll()

    override suspend fun getArtistById(id: String): ArtistLocal = artistDao.getArtistById(id)

    override suspend fun getFavoriteArtistList(): List<ArtistLocal> = artistDao.getFavoriteArtists()

    override suspend fun makeArtistFavorite(id: String, state: Boolean) = artistDao.makeArtistFavorite(id,state)

    override suspend fun getArtistTopTracks(): List<AlbumLocal> = albumDao.getAll()

    override suspend fun addIdColum(id: String) = albumDao.addIdColum(id)

    override suspend fun deleteTracks() = albumDao.deleteAll()
}