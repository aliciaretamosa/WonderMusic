package com.example.wondermusic.domain.usecase

import android.util.Log
import com.example.wondermusic.data.ArtistRepository

class GetArtistFavoriteUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invoke() = artistRepository.getFavoriteArtists()
}