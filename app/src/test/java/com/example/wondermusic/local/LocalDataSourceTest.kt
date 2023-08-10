package com.example.wondermusic.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.data.local.AlbumDao
import com.example.wondermusic.data.local.ArtistDao
import com.example.wondermusic.data.local.LocalDataSourceImpl
import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.FollowersLocal
import com.example.wondermusic.data.local.model.ImagesLocal
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
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class RemoteDataSourceTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var artistDao: ArtistDao

    @MockK(relaxed = true)
    private lateinit var albumDao: AlbumDao

    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getArtistLocalList EXPECT local data`() = runTest {
        coEvery { artistDao.getAll() } returns getListArtistLocal()

        val repo = LocalDataSourceImpl(
            artistDao = artistDao,
            albumDao = albumDao
        )

        val res = repo.getArtistList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getArtistByIdLocalList EXPECT local data`() = runTest {
        coEvery { artistDao.getArtistById("test-id") } returns getArtistLocal()

        val repo = LocalDataSourceImpl(
            artistDao = artistDao,
            albumDao = albumDao
        )

        val res = repo.getArtistById("test-id")


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(ArtistLocal::class.java))
        MatcherAssert.assertThat(res.id,`is`("test-id"))

    }

    @Test
    fun `WHEN getFavoriteArtistLocalList EXPECT local data`() = runTest {
        coEvery { artistDao.getFavoriteArtists() } returns getListArtistLocal()

        val repo = LocalDataSourceImpl(
            artistDao = artistDao,
            albumDao = albumDao
        )

        val res = repo.getFavoriteArtistList()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

    @Test
    fun `WHEN getArtistTopTracksLocalList EXPECT local data`() = runTest {
        coEvery { albumDao.getAll() } returns getListAlbumLocal()

        val repo = LocalDataSourceImpl(
            artistDao = artistDao,
            albumDao = albumDao
        )

        val res = repo.getArtistTopTracks()


        MatcherAssert.assertThat(res, CoreMatchers.instanceOf(List::class.java))
        MatcherAssert.assertThat(res.size, CoreMatchers.`is`(2))
    }

}
fun getArtistLocal() =
    ArtistLocal(
        "test-id",
        "SampleName",
        FollowersLocal(10),
        listOf(),
        ImagesLocal(10,"",10),
        favorite = false
    )

fun getListAlbumLocal() =
    listOf(
        AlbumLocal(
            "test-id",
            "SampleName",
            ImagesLocal(0,"",0),
            "test-artist-id"
        ),
        AlbumLocal(
            "test-id",
            "SampleName",
            ImagesLocal(0,"",0),
            "test-artist-id"
        )
    )
fun getListArtistLocal() =
        listOf(
            ArtistLocal(
                "test-id",
                "SampleName",
                FollowersLocal(10),
                listOf(),
                ImagesLocal(10,"",10),
                favorite = false
            ),
            ArtistLocal(
                "test-id",
                "SampleName",
                FollowersLocal(10),
                listOf(),
                ImagesLocal(10,"",10),
                favorite = false
            ),
        )