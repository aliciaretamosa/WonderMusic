package com.keepcoding.androidsuperpoderes.data

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.data.ArtistRepositoryImpl
import com.example.wondermusic.data.local.LocalDataSource
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.FollowersLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.data.remote.RemoteDataSource
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.FollowersDto
import com.example.wondermusic.data.remote.dto.ImagesDto
import com.example.wondermusic.domain.model.ArtistModel
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.test.runTest
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class HeroRepositoryImplTest {
    @get:Rule
    val instantExecutorRule: InstantTaskExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val defaultDispatcherRule: DefaultDispatcherRule = DefaultDispatcherRule()

    @MockK(relaxed = true)
    private lateinit var localDataSource: LocalDataSource

    @MockK(relaxed = true)
    private lateinit var remoteDataSource: RemoteDataSource


    @Before
    fun setup() {
        MockKAnnotations.init(this)
    }

    @Test
    fun `WHEN getArtistList EXPECT local data`() = runTest {
        coEvery { localDataSource.getArtistList() } returns getListLocal()
        coEvery { remoteDataSource.getArtistList() } returns listOf<ArtistDto>()

        val repo = ArtistRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getArtistList()


        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }

    @Test
    fun `WHEN getArtistList EXPECT remote data`() = runTest {
        coEvery { localDataSource.getArtistList() } returns listOf<ArtistLocal>()
        coEvery { remoteDataSource.getArtistList() } returns getListRemote()
        coEvery { localDataSource.insertArtistList(getListLocal()) }

        val repo = ArtistRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getArtistList()

        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }

    @Test
    fun `WHEN getArtistById EXPECT local data`() = runTest {
        coEvery { localDataSource.getArtistById("123") } returns getArtistLocal()
        val repo = ArtistRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getArtistById("123")


        assertThat(res, instanceOf(ArtistModel::class.java))
    }

    @Test
    fun `WHEN getFavoriteArtistList EXPECT local data`() = runTest {
        coEvery { localDataSource.getFavoriteArtistList() } returns getListLocal()
        val repo = ArtistRepositoryImpl(
            localDataSource = localDataSource,
            remoteDataSource = remoteDataSource
        )

        val res = repo.getFavoriteArtists()


        assertThat(res, instanceOf(List::class.java))
        assertThat(res.size, `is`(2))
    }
}

fun getListLocal() = listOf(
        ArtistLocal("id", "name", FollowersLocal(10), listOf(),ImagesLocal(10,"https://photo-url",10), true),
        ArtistLocal("id", "name", FollowersLocal(10), listOf(),ImagesLocal(10,"https://photo-url",10), true)
    )

fun getArtistLocal() = ArtistLocal("id", "name", FollowersLocal(10), listOf(),ImagesLocal(10,"https://photo-url",10), true)


fun getListRemote() = listOf<ArtistDto>(
    ArtistDto("id", "name", listOf<ImagesDto>(ImagesDto(0,"",0), ImagesDto(0,"",0)) , FollowersDto(10), listOf()),
    ArtistDto("id", "name", listOf<ImagesDto>(ImagesDto(0,"",0), ImagesDto(0,"",0)) , FollowersDto(10), listOf()),
)