package com.example.wondermusic.data

import com.example.wondermusic.data.local.LocalDataSource
import com.example.wondermusic.data.mappers.toArtistLocal
import com.example.wondermusic.data.mappers.toArtistModel
import com.example.wondermusic.data.remote.RemoteDataSource
import com.example.wondermusic.domain.model.ArtistModel

class ArtistRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ArtistRepository{
    override suspend fun getArtistList(): List<ArtistModel> {
        val localData = localDataSource.getArtistList()

        // Lógica de coordinación de datos
        if (localData.isNotEmpty()) {
            return localData.map {
                it.toArtistModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistList().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertArtistList(remoteData.map { it.toArtistLocal() })

            return remoteData.map {
                it.toArtistModel()
            }
        }
    }

    override suspend fun getArtistById(id:String): ArtistModel =
        localDataSource.getArtistById(id).toArtistModel()
}