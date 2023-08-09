package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.AlbumTestDataBuilder
import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ImagesModel
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import com.example.wondermusic.domain.usecase.GetTopTracksUseCase
import com.example.wondermusic.presentation.detail.DetailViewModel
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

class DetailViewModelTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var getDetailUseCase: GetDetailUseCase

    @MockK(relaxed = true)
    private lateinit var getTopTracksUseCase: GetTopTracksUseCase

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { getDetailUseCase.invoke("test-id") } returns
                ArtistTestDataBuilder().buildSingle()

        coEvery { getTopTracksUseCase.invokeRelsB("test-id")}

        val viewModel = DetailViewModel(getDetailUseCase,getTopTracksUseCase)

        viewModel.getArtist("test-id")

        val res = viewModel.artist.getOrAwaitValue()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN detail viewModel top tracks getData EXPECT returns data`() = runTest {
        coEvery { getDetailUseCase.invoke("test-id") } returns
                ArtistTestDataBuilder().buildSingle()

        coEvery { getTopTracksUseCase.invokeRelsB("test-id")} returns getAlbumListModel()

        val viewModel = DetailViewModel(getDetailUseCase,getTopTracksUseCase)

        viewModel.getTopTracks("test-id")

        val res = viewModel.tracksList.getOrAwaitValue()

        assertThat(res.size, `is`(2))
    }
}

fun getAlbumListModel() = listOf(
    AlbumModel("id", "name", ImagesModel(10,"https://photo-url",10)),
    AlbumModel("id", "name", ImagesModel(10,"https://photo-url",10))
)