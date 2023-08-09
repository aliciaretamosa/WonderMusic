package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.domain.usecase.GetArtistFavoriteUseCase
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import com.example.wondermusic.presentation.detail.DetailViewModel
import com.example.wondermusic.presentation.favorite.ArtistFavoriteViewModel
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.keepcoding.androidsuperpoderes.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteViewModelTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getArtistFavoriteUseCase: GetArtistFavoriteUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN favorite viewModel getFavoriteArtist EXPECT returns data`() = runTest {
        coEvery { getArtistFavoriteUseCase.invoke() } returns ArtistTestDataBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = ArtistFavoriteViewModel(getArtistFavoriteUseCase)

        viewModel.getFavoriteArtists()

        val res = viewModel.favoriteList.getOrAwaitValue()

        assertThat(res.size, `is`(15))
    }


}