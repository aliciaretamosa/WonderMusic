package com.example.wondermusic.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.wondermusic.data.local.model.ArtistLocal

@Database(entities = [ArtistLocal::class], version = 1, exportSchema = false)
abstract class ArtistDatabase: RoomDatabase() {
    abstract fun artistDao(): ArtistDao
}