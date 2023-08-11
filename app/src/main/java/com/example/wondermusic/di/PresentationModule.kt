package com.example.wondermusic.di

import com.example.wondermusic.presentation.detail.DetailViewModel
import com.example.wondermusic.presentation.favorite.ArtistFavoriteViewModel
import com.example.wondermusic.presentation.list.ArtistListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ArtistListViewModel(get(),get()) }
    viewModel { DetailViewModel(get(),get()) }
    viewModel { ArtistFavoriteViewModel(get()) }

}
