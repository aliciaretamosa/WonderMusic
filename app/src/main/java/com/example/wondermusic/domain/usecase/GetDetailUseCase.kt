package com.example.wondermusic.domain.usecase

import com.example.wondermusic.data.ArtistRepository
import com.example.wondermusic.domain.model.ArtistModel

class GetDetailUseCase(
    private val artistRepository: ArtistRepository
) {
    suspend fun invoke(id: String) : ArtistModel = artistRepository.getArtistById(id)
}