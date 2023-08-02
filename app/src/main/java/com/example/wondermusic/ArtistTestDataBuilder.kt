package com.example.wondermusic

import com.example.wondermusic.domain.model.ArtistModel

class ArtistTestDataBuilder {
    val id = "test-id"
    var name = ""
    var photoUrl = ""
    var photoHeight = 0
    var photoWidth = 0
    var genres = listOf<String>()
    var popularity = 0
    var numElements: Int = 1

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

    fun withPhotoWidth(photoHeight: Int): ArtistTestDataBuilder {
        this.photoWidth = photoWidth
        return this
    }

    fun withGenres(genres: List<String>): ArtistTestDataBuilder {
        this.genres = genres
        return this
    }

    fun withPopularity(popularity: Int): ArtistTestDataBuilder {
        this.popularity = popularity
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
                    photoUrl = photoUrl,
                    photoHeight = photoHeight,
                    photoWidth = photoWidth,
                    //genres = genres,
                    popularity = popularity
                )
            )
        }

        return list.toList()
    }

    fun buildSingle() = ArtistModel(
        id = id,
        name = name,
        photoUrl = photoUrl,
        photoHeight = photoHeight,
        photoWidth = photoWidth,
        //genres = genres,
        popularity = popularity
    )
}