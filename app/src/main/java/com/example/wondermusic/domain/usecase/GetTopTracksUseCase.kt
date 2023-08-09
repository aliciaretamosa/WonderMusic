package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository

class GetTopTracksUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invokeRelsB(id: String) = artistRepository.getArtistTopTracksRelsB(id)
    suspend fun invokeRosalia(id: String) = artistRepository.getArtistTopTracksRosalia(id)
    suspend fun invokeAnaMena(id: String) = artistRepository.getArtistTopTracksAnaMena(id)
    suspend fun invokeBadgyal(id: String) = artistRepository.getArtistTopTracksBadGyal(id)
    suspend fun invokeHalsey(id: String) = artistRepository.getArtistTopTracksHalsey(id)
    suspend fun invokeBillie(id: String) = artistRepository.getArtistTopTracksBillie(id)
    suspend fun invokeLadyGaga(id: String) = artistRepository.getArtistTopTracksLadyGaga(id)
    suspend fun invokeDeadmau(id: String) = artistRepository.getArtistTopTracksDeadmau(id)
    suspend fun invokeRatata(id: String) = artistRepository.getArtistTopTracksRatata(id)
    suspend fun invokeAvicii(id: String) = artistRepository.getArtistTopTracksAvicii(id)

}