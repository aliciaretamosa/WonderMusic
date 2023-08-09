package com.keepcoding.androidsuperpoderes.presentation.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.domain.usecase.GetArtistListUseCase
import com.example.wondermusic.domain.usecase.MakeArtistFavoriteUseCase
import com.example.wondermusic.presentation.detail.DetailViewModel
import com.example.wondermusic.presentation.list.ArtistListViewModel
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.keepcoding.androidsuperpoderes.testutil.getOrAwaitValue
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.*
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HeroListViewModelTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getArtistListUseCase: GetArtistListUseCase

    @MockK(relaxed = true)
    private lateinit var makeArtistFavoriteUseCase: MakeArtistFavoriteUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun tearDown() {
        // Liberar recursos del test
    }

    @Test
    fun `WHEN viewModel init EXPECT data at LiveData`() = runTest {
        coEvery { getArtistListUseCase.invoke() } returns ArtistTestDataBuilder()
            .withNumElements(15)
            .buildList()

        val viewModel = ArtistListViewModel(getArtistListUseCase, makeArtistFavoriteUseCase)

        val res = viewModel.artistList.getOrAwaitValue()

        assertThat(res.size, `is`(15))

    }

}
