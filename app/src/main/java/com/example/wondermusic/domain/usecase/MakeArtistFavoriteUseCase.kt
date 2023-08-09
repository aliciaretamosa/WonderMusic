package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository

class MakeArtistFavoriteUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invoke(id: String, state: Boolean) = artistRepository.makeArtistFavorite(id, state)
}