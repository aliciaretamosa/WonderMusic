package com.example.wondermusic.data.remote

import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.ArtistsDto
import com.example.wondermusic.data.remote.dto.SearchDto
import org.koin.android.BuildConfig
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


const val TOKEN =
    "BQCE0YKq4-kH3sFKGsAWDTX-ez2fKKg5OUpXEA2YDsxMwGY1bprFyhc3xYrUyPnLVr3dnK2FkkNnnnayGqsOI9rjUv_XvqnAYijkGFvvs70Cz7ZX5-Y"

interface ArtistApi {

    @GET("artists?ids=2IMZYfNi21MGqxopj9fWx8%2C7ltDVBr6mKbRvohxheJ9h1%2C6k8mwkKJKKjBILo7ypBspl%2C4F4pp8NUW08JuXwnoxglpN%2C26VFTg2z8YR0cCuwLzESi2%2C6qqNVTkY8uBg9cP3Jd7DAH%2C1HY2Jd0NmPuamShAr6KMms%2C2CIMQHirSU0MQqyYHq0eOx%2C57dN52uHvrHOxijzpIgu3E%2C1vCWHaC5f2uS3yhpwWbIA6")
    @Headers("Authorization: Bearer $TOKEN")
    suspend fun getArtistList(): ArtistsDto

}