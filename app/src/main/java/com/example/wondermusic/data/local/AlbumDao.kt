package com.example.wondermusic.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.wondermusic.data.local.model.AlbumLocal

@Dao
interface AlbumDao {
    @Query("SELECT * FROM AlbumTable")
    suspend fun getAll(): List<AlbumLocal>

    @Query("SELECT * FROM AlbumTable WHERE albumId=:id")
    suspend fun getAlbumById(id: String) : AlbumLocal

    @Query("UPDATE AlbumTable SET artistId = :id")
    suspend fun addIdColum(id: String)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(list: List<AlbumLocal>)

    @Delete
    suspend fun delete(model: AlbumLocal)

    @Query("DELETE FROM AlbumTable")
    fun deleteAll()
}