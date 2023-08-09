package com.example.wondermusic.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.wondermusic.data.converters.Converters
import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.ImagesLocal

@Database(entities = [ArtistLocal::class, ImagesLocal::class, AlbumLocal::class], version = 18, exportSchema = true)
@TypeConverters(Converters::class)
abstract class ArtistDatabase: RoomDatabase() {
    abstract fun artistDao(): ArtistDao
    abstract fun albumDao(): AlbumDao

}