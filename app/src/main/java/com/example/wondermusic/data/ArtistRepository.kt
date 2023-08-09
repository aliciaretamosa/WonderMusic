package com.example.wondermusic.data

import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ArtistModel

interface ArtistRepository {
    suspend fun getArtistList(): List<ArtistModel>

    suspend fun getArtistById(id:String): ArtistModel

    suspend fun getFavoriteArtists() : List<ArtistModel>

    suspend fun makeArtistFavorite(id:String, state: Boolean)

    suspend fun getArtistTopTracksRelsB(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksRosalia(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksAnaMena(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksBadGyal(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksHalsey(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksBillie(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksLadyGaga(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksDeadmau(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksRatata(id: String): List<AlbumModel>

    suspend fun getArtistTopTracksAvicii(id: String): List<AlbumModel>

}