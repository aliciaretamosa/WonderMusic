package com.example.wondermusic.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.ImagesLocal

@Dao
interface ArtistDao {
    @Query("SELECT * FROM ArtistTable")
    suspend fun getAll(): List<ArtistLocal>

    @Query("SELECT * FROM ArtistTable WHERE id=:id")
    suspend fun getArtistById(id: String) : ArtistLocal

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ArtistLocal>)

    @Delete
    suspend fun delete(model: ArtistLocal)

}