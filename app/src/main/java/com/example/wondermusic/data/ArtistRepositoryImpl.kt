package com.example.wondermusic.data

import com.example.wondermusic.data.local.LocalDataSource
import com.example.wondermusic.data.mappers.toAlbumLocal
import com.example.wondermusic.data.mappers.toAlbumModel
import com.example.wondermusic.data.mappers.toArtistLocal
import com.example.wondermusic.data.mappers.toArtistModel
import com.example.wondermusic.data.remote.RemoteDataSource
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ArtistModel

class ArtistRepositoryImpl(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : ArtistRepository{
    override suspend fun getArtistList(): List<ArtistModel> {
        val localData = localDataSource.getArtistList()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toArtistModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistList().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertArtistList(remoteData.map { it.toArtistLocal() })

            remoteData.map {
                it.toArtistModel()
            }
        }
    }

    override suspend fun getArtistById(id:String): ArtistModel =
        localDataSource.getArtistById(id).toArtistModel()

    override suspend fun getFavoriteArtists(): List<ArtistModel> {
        val localData = localDataSource.getFavoriteArtistList()
            return localData.map {
                it.toArtistModel()
            }
    }

    override suspend fun makeArtistFavorite(id: String, state: Boolean) {
        localDataSource.makeArtistFavorite(id, state)
    }

    override suspend fun getArtistTopTracksRelsB(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksRelsB().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }


    override suspend fun getArtistTopTracksRosalia(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksRosalia().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksAnaMena(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksAnaMena().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksBadGyal(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksBadgyal().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksHalsey(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksHalsey().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksBillie(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksBillie().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksLadyGaga(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksLadyGaga().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksDeadmau(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksDeadmau().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksRatata(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksRatata().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }

    override suspend fun getArtistTopTracksAvicii(id: String): List<AlbumModel> {
        localDataSource.deleteTracks()
        val localData = localDataSource.getArtistTopTracks()

        return if (localData.isNotEmpty()) {
            localData.map {
                it.toAlbumModel()
            }
        } else {
            val remoteData = remoteDataSource.getArtistTopTracksAvicii().filter {
                (it.id?.isNotEmpty() == true)
            }
            localDataSource.insertTopTracksList(remoteData.map { it.toAlbumLocal() })
            localDataSource.addIdColum(id)

            remoteData.map {
                it.toAlbumModel()
            }
        }
    }
}