package com.example.wondermusic.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.RoomWarnings

@SuppressWarnings(RoomWarnings.PRIMARY_KEY_FROM_EMBEDDED_IS_DROPPED)
@Entity(tableName = "ArtistTable")
data class ArtistLocal (
    @PrimaryKey @ColumnInfo(name = "id") val id: String,
    @ColumnInfo(name = "name") val name: String,
    @Embedded val followers: FollowersLocal,
    @ColumnInfo(name = "genres") val genres: List<String>,
    @Embedded val image: ImagesLocal
    )