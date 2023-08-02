package com.example.wondermusic.data.remote.dto

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey
import com.squareup.moshi.Json

data class ArtistDto (
    @Json (name = "id") val id: String?,
    @Json(name = "name") val name: String?,
    @Json(name = "photoUrl") val photoUrl: String?,
    @Json(name = "photoHeight") val photoHeight: Int?,
    @Json(name = "photoWidth") val photoWidth: Int?,
   // @Json(name = "genres") val genres: List<String>?,
    @Json(name = "popularity") val popularity: Int?
    )