package com.example.wondermusic.di

import android.content.Context
import androidx.room.Room
import com.example.wondermusic.data.ArtistRepository
import com.example.wondermusic.data.ArtistRepositoryImpl
import com.example.wondermusic.data.local.AlbumDao
import com.example.wondermusic.data.local.ArtistDao
import com.example.wondermusic.data.local.ArtistDatabase
import com.example.wondermusic.data.local.LocalDataSource
import com.example.wondermusic.data.local.LocalDataSourceImpl
import com.example.wondermusic.data.remote.ArtistApi
import com.example.wondermusic.data.remote.RemoteDataSource
import com.example.wondermusic.data.remote.RemoteDataSourceImpl
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

//val baseUrl = BuildConfig.BASE_URL
const val baseUrl = "https://api.spotify.com/v1/"
val dataModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor(HttpLoggingInterceptor.Logger.DEFAULT).apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create(get()))
            .build()
    }

    single<Moshi> {
        Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    single<ArtistRepository> { ArtistRepositoryImpl(get(), get()) }

    single<RemoteDataSource> { RemoteDataSourceImpl(get()) }

    single<LocalDataSource> { LocalDataSourceImpl(get(),get()) }

    single<ArtistApi> {
        getArtistApi(get())
    }

    single {
        getDatabase(get())
    }

    single {
        providesArtistDao(get())
    }

    single {
        providesAlbumDao(get())
    }

}

private fun getArtistApi(retrofit: Retrofit) =
    retrofit.create(ArtistApi::class.java)

private fun getDatabase(context: Context) : ArtistDatabase =
    Room.databaseBuilder(
        context,
        ArtistDatabase::class.java, "artist-db"
    ).fallbackToDestructiveMigration()
        .build()

private fun providesArtistDao(db: ArtistDatabase) : ArtistDao =
    db.artistDao()

private fun providesAlbumDao(db: ArtistDatabase) : AlbumDao =
    db.albumDao()
