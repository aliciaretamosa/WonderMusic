package com.example.wondermusic.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "FollowersTable")
data class FollowersLocal (
    @PrimaryKey @ColumnInfo(name = "total") val total: Int,
)