package com.keepcoding.androidsuperpoderes.data.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.wondermusic.data.remote.ArtistApi
import com.example.wondermusic.di.baseUrl
import com.keepcoding.androidsuperpoderes.testutil.DefaultDispatcherRule
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.BeforeClass
import org.junit.Rule
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

@ExperimentalCoroutinesApi
class ArtistApiTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val mainDispatcherRule = DefaultDispatcherRule()


    private lateinit var api: ArtistApi

    @Before
    fun setup() {
        api = retrofit.create(ArtistApi::class.java)
    }

    @Test
    fun `WHEN request artistList list EXPECT result`() = runTest {
        val result = api.getArtistList()

        assertThat(result.artists.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request relsBTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksRelsB()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request rosaliaTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksRosalia()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request anaMenaTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksAnaMena()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request billieTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksBillie()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request ratataTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksRatata()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request aviciiTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksAvicii()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    @Test
    fun `WHEN request ladyGagaTopTracks list EXPECT result`() = runTest {
        val result = api.getArtistTopTracksLadyGaga()
        assertThat(result.tracks.isNotEmpty(), `is`(true))
    }

    companion object {
        private lateinit var retrofit: Retrofit

        @BeforeClass
        @JvmStatic
        fun setupCommon() {
            retrofit = Retrofit.Builder()
                // lo ideal es probar contra un entorno estable
                // entorno de QA
                .baseUrl(baseUrl)
                .client(
                    OkHttpClient.Builder()
                        .addInterceptor(
                            HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT)
                                .apply {
                                    level = HttpLoggingInterceptor.Level.BODY
                                }).build()
                )
                .addConverterFactory(
                    MoshiConverterFactory.create(
                        Moshi.Builder()
                            .addLast(KotlinJsonAdapterFactory())
                            .build()
                    )
                ).build()
        }
    }
}

/*
Static context en Java
class Test {

    public static void doSomething() {

    }
}

Test.doSomething()
Test().doSomething()

 */