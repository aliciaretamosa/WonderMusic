package com.example.wondermusic.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import androidx.room.Update
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.ImagesLocal

@Dao
interface ArtistDao {
    @Query("SELECT * FROM ArtistTable")
    suspend fun getAll(): List<ArtistLocal>

    @Query("SELECT * FROM ArtistTable WHERE id=:id")
    suspend fun getArtistById(id: String) : ArtistLocal

    @Query("SELECT * FROM ArtistTable WHERE favorite = 1")
    suspend fun getFavoriteArtists() : List<ArtistLocal>

    @Query("UPDATE ArtistTable SET favorite = :state WHERE id = :id ")
    suspend fun makeArtistFavorite(id: String, state: Boolean)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<ArtistLocal>)

    @Delete
    suspend fun delete(model: ArtistLocal)

}