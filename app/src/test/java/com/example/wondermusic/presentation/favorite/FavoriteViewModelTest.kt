package com.keepcoding.androidsuperpoderes.presentation.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.domain.usecase.GetDetailUseCase
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

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN detail viewModel getData EXPECT returns data`() = runTest {
        coEvery { getDetailUseCase.invoke("test-id") } returns
                ArtistTestDataBuilder().buildSingle()

        val viewModel = DetailViewModel(getDetailUseCase)

        viewModel.getHero("test-id")

        val res = viewModel.artist.getOrAwaitValue()

        assertThat(res.id, `is`("test-id"))
    }


}