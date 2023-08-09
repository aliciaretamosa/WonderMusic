package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.AlbumDto
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.TrackDto

interface RemoteDataSource {
    suspend fun getArtistList(): List<ArtistDto>
    suspend fun getArtistTopTracksRelsB(): List<AlbumDto>
    suspend fun getArtistTopTracksRosalia(): List<AlbumDto>
    suspend fun getArtistTopTracksAnaMena(): List<AlbumDto>
    suspend fun getArtistTopTracksBadgyal(): List<AlbumDto>
    suspend fun getArtistTopTracksHalsey(): List<AlbumDto>
    suspend fun getArtistTopTracksBillie(): List<AlbumDto>
    suspend fun getArtistTopTracksLadyGaga(): List<AlbumDto>
    suspend fun getArtistTopTracksDeadmau(): List<AlbumDto>
    suspend fun getArtistTopTracksRatata(): List<AlbumDto>
    suspend fun getArtistTopTracksAvicii(): List<AlbumDto>
}