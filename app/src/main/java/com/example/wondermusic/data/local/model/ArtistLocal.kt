package com.example.wondermusic.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ArtistTable")
data class ArtistLocal (

    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "photoUrl") val photoUrl: String,
    @ColumnInfo(name = "photoHeight") val photoHeight: Int,
    @ColumnInfo(name = "photoWidth") val photoWidth: Int,
    //@ColumnInfo(name = "genres") val genres: List<String>,
    @ColumnInfo(name = "popularity") val popularity: Int
    )