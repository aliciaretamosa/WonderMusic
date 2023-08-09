package com.example.wondermusic.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AlbumTable")
data class AlbumLocal (
    @PrimaryKey @ColumnInfo(name = "albumId") val albumId: String,
    @ColumnInfo(name = "name") val name: String,
    @Embedded val image: ImagesLocal,
    @ColumnInfo(name = "artistId") val artistId: String
)