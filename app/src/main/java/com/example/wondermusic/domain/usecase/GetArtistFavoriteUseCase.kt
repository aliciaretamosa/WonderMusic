package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository

class GetArtistFavoriteUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invoke() = artistRepository.getFavoriteArtists()
}