package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository

class GetArtistListUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invoke() = artistRepository.getArtistList()
}