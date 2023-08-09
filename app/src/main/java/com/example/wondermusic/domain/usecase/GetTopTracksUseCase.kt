package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository
import com.example.wondermusic.domain.model.AlbumModel

class GetTopTracksUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invokeRelsB(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksRelsB(id)
    suspend fun invokeRosalia(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksRosalia(id)
    suspend fun invokeAnaMena(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksAnaMena(id)
    suspend fun invokeBadgyal(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksBadGyal(id)
    suspend fun invokeHalsey(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksHalsey(id)
    suspend fun invokeBillie(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksBillie(id)
    suspend fun invokeLadyGaga(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksLadyGaga(id)
    suspend fun invokeDeadmau(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksDeadmau(id)
    suspend fun invokeRatata(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksRatata(id)
    suspend fun invokeAvicii(id: String) : List<AlbumModel> = artistRepository.getArtistTopTracksAvicii(id)

}