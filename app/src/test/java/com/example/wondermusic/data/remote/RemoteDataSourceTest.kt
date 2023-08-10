package com.example.wondermusic.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.data.local.ArtistDao
import com.example.wondermusic.data.local.LocalDataSourceImpl
import com.example.wondermusic.data.remote.dto.AlbumDto
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.FollowersDto
import com.example.wondermusic.data.remote.dto.ImagesDto
import com.example.wondermusic.data.remote.dto.TrackDto
import com.example.wondermusic.data.remote.dto.TracksDto
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.koin.androidx.compose.get

class RemoteDataSourceTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var artistApi: ArtistApi

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getArtistRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistList() } returns getListArtistRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getArtistTopTracskRelsBRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksRelsB() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksRelsB()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getArtistTopTracskRosaliaRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksRosalia() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksRosalia()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getArtistTopTracskAnaMenaRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksAnaMena() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksAnaMena()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getArtistTopTracskHalseyRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksHalsey() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksHalsey()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
    @Test
    fun `WHEN getArtistTopTracskBillieRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksBillie() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksBillie()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
    @Test
    fun `WHEN getArtistTopTracskDeadmauRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksDeadmau() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksDeadmau()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
    @Test
    fun `WHEN getArtistTopTracskRatataRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksRatata() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksRatata()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
    @Test
    fun `WHEN getArtistTopTracskLadyGagaRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksLadyGaga() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksLadyGaga()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getArtistTopTracskAviciiRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksAvicii() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksAvicii()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }

    @Test
    fun `WHEN getArtistTopTracskBadGyalRemoteList EXPECT local data`() = runTest {
        coEvery { artistApi.getArtistTopTracksBadgyal() } returns getTracksRemote()

        val repo = RemoteDataSourceImpl(
            artistApi = artistApi
        )

        val res = repo.getArtistTopTracksBadgyal()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(1))
    }
}
fun getTracksRemote() =
    TracksDto(
        listOf(
            TrackDto(
                AlbumDto(
                    "test-id",
                    "test-album",
                    listOf(ImagesDto(0,"",0))
                ),
            )
        )
    )
fun getListArtistRemote() =
    ArtistsDto(
        listOf(
            ArtistDto(
                "test-id",
                "SampleName",
                listOf(ImagesDto(10,"",10)),
                FollowersDto(10),
                listOf()
            ),

            ArtistDto(
                "test-id",
                "SampleName",
                listOf(ImagesDto(10,"",10)),
                FollowersDto(10),
                listOf()
            ),
        )
    )