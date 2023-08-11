package com.example.wondermusic

import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.model.FollowersModel
import com.example.wondermusic.domain.model.ImagesModel

class ArtistTestDataBuilder {
    val id = "test-id"
    var name = ""
    private var photoUrl = ""
    private var photoHeight = 0
    private var photoWidth = 0
    private var genres = listOf<String>()
    private var followers: FollowersModel = FollowersModel(10)
    private var numElements: Int = 1
    var images: ImagesModel = ImagesModel(10,"",10)
    var favorite = false

    fun withName(name: String): ArtistTestDataBuilder {
        this.name = name
        return this
    }

    fun withPhotoUrl(photoUrl: String): ArtistTestDataBuilder {
        this.photoUrl = photoUrl
        return this
    }

    fun withPhotoHeight(photoHeight: Int): ArtistTestDataBuilder {
        this.photoHeight = photoHeight
        return this
    }

    fun withPhotoWidth(photoWidth: Int): ArtistTestDataBuilder {
        this.photoWidth = photoWidth
        return this
    }

    fun withGenres(genres: List<String>): ArtistTestDataBuilder {
        this.genres = genres
        return this
    }

    fun withNumElements(numElements: Int): ArtistTestDataBuilder {
        this.numElements = numElements

        return this
    }


    fun buildList(): List<ArtistModel> {
        val list = mutableListOf<ArtistModel>()

        for(i in 0 until numElements) {
            list.add(
                ArtistModel(
                    id,
                    name = name,
                    images = images,
                    genres = genres,
                    followers =  followers,
                    favorite = favorite
                )
            )
        }

        return list.toList()
    }


    fun buildSingle() = ArtistModel(
        id = id,
        name = name,
        //genres = genres,
        images = images,
        genres = genres,
        followers =  followers,
        favorite = favorite
    )
}