package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.SearchDto
import org.koin.android.BuildConfig
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


const val TOKEN =
    "BQBpvUlwMnsUmXhqKTmQEzBrycu8Jym4Xrg_rc0ELg4_7FCe4Y4z0dmSUUzhKA8wZtVkU4-JOQZuASRpwc3jfl8xXxYwjqgScx4WkvrEMu3mllwGEIA"

interface ArtistApi {

    @GET("artists/1HY2Jd0NmPuamShAr6KMms")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistList(): List<ArtistDto>

}