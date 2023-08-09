package com.example.wondermusic.data.local

import android.util.Log
import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.remote.dto.TrackDto

interface LocalDataSource {
     suspend fun insertArtistList(artistList: List<ArtistLocal>)

     suspend fun insertTopTracksList(tracksList: List<AlbumLocal>)

     suspend fun getArtistList() : List<ArtistLocal>

     suspend fun getArtistById(id: String): ArtistLocal

     suspend fun getFavoriteArtistList() : List<ArtistLocal>

     suspend fun makeArtistFavorite(id: String, state: Boolean)

     suspend fun getArtistTopTracks(): List<AlbumLocal>

     suspend fun addIdColum(id: String)

     suspend fun deleteTracks()
}