package com.keepcoding.androidsuperpoderes.di

import com.example.wondermusic.presentation.detail.DetailViewModel
import com.example.wondermusic.presentation.list.ArtistListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val presentationModule = module {
    viewModel { ArtistListViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
