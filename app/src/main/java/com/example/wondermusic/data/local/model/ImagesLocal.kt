package com.example.wondermusic.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ImagesTable")
data class ImagesLocal (
    @ColumnInfo(name = "height") val height: Int,
    @PrimaryKey @ColumnInfo(name = "url") val url: String,
    @ColumnInfo(name = "width") val width: Int,
    )