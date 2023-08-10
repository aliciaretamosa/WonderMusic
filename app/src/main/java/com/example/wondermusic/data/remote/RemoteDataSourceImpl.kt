package com.example.wondermusic.data.remote

import android.util.Log
import com.example.wondermusic.data.remote.dto.AlbumDto
import com.example.wondermusic.data.remote.dto.ArtistDto

class RemoteDataSourceImpl(
    private val artistApi: ArtistApi
): RemoteDataSource {
    override suspend fun getArtistList(): List<ArtistDto> =
        artistApi.getArtistList().artists

    override suspend fun getArtistTopTracksRelsB(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksRelsB().tracks)
            result +=  i.album
        return  result
    }

    override suspend fun getArtistTopTracksRosalia(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksRosalia().tracks)
            result +=  i.album
        return  result
    }

    override suspend fun getArtistTopTracksAnaMena(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksAnaMena().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksBadgyal(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksBadgyal().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksHalsey(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksHalsey().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksBillie(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksBillie().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksLadyGaga(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksLadyGaga().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksDeadmau(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksDeadmau().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksRatata(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksRatata().tracks)
            result +=  i.album
        return  result    }

    override suspend fun getArtistTopTracksAvicii(): List<AlbumDto> {
        val result: MutableList<AlbumDto> = mutableListOf()
        for (i in artistApi.getArtistTopTracksAvicii().tracks)
            result +=  i.album
        return  result    }
}