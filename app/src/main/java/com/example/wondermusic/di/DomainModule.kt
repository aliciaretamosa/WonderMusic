package com.keepcoding.androidsuperpoderes.di

import com.example.wondermusic.domain.usecase.GetArtistFavoriteUseCase
import com.example.wondermusic.domain.usecase.GetArtistListUseCase
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import com.example.wondermusic.domain.usecase.GetTopTracksUseCase
import com.example.wondermusic.domain.usecase.MakeArtistFavoriteUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetArtistListUseCase(get()) }
    single { GetDetailUseCase(get()) }
    single { GetArtistFavoriteUseCase(get()) }
    single { MakeArtistFavoriteUseCase(get()) }
    single {GetTopTracksUseCase(get())}
}
