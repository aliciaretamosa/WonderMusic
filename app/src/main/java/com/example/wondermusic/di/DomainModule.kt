package com.keepcoding.androidsuperpoderes.di

import com.example.wondermusic.domain.usecase.GetArtistListUseCase
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import org.koin.dsl.module

val domainModule = module {
    single { GetArtistListUseCase(get()) }
    single { GetDetailUseCase(get()) }
}
