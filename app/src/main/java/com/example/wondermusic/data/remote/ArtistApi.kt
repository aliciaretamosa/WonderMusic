package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.TracksDto
import retrofit2.http.GET
import retrofit2.http.Headers


const val TOKEN =
    "BQC77vHPNVDvstB9Kaxqlmy4KMOa0J_UT7OxsXXd8cD28p7lzz0pPCCfhpmp5ycYA8uReGTHwgXEucvQLdrfh6fjYl6H8_lq6xbtZB1uvXLoH6rJhsg"

interface ArtistApi {

    @GET("artists?ids=2IMZYfNi21MGqxopj9fWx8%2C7ltDVBr6mKbRvohxheJ9h1%2C6k8mwkKJKKjBILo7ypBspl%2C4F4pp8NUW08JuXwnoxglpN%2C26VFTg2z8YR0cCuwLzESi2%2C6qqNVTkY8uBg9cP3Jd7DAH%2C1HY2Jd0NmPuamShAr6KMms%2C2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistList(): ArtistsDto

    @GET("artists/2IMZYfNi21MGqxopj9fWx8/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksRelsB(): TracksDto

    @GET("artists/7ltDVBr6mKbRvohxheJ9h1/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksRosalia(): TracksDto

    @GET("artists/6k8mwkKJKKjBILo7ypBspl/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksAnaMena(): TracksDto

    @GET("artists/4F4pp8NUW08JuXwnoxglpN/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksBadgyal(): TracksDto

    @GET("artists/26VFTg2z8YR0cCuwLzESi2/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksHalsey(): TracksDto

    @GET("artists/6qqNVTkY8uBg9cP3Jd7DAH/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksBillie(): TracksDto

    @GET("artists/1HY2Jd0NmPuamShAr6KMms/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksLadyGaga(): TracksDto

    @GET("artists/2CIMQHirSU0MQqyYHq0eOx/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksDeadmau(): TracksDto

    @GET("artists/57dN52uHvrHOxijzpIgu3E/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksRatata(): TracksDto

    @GET("artists/1vCWHaC5f2uS3yhpwWbIA6/top-tracks?market=ES")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistTopTracksAvicii(): TracksDto

}

