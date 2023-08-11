package com.example.wondermusic

import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ImagesModel

class AlbumTestDataBuilder {
    val id = "test-id"
    var name = ""
    private var numElements: Int = 1
    var images: ImagesModel = ImagesModel(10,"",10)

    fun withName(name: String): AlbumTestDataBuilder {
        this.name = name
        return this
    }

    fun withNumElements(numElements: Int): AlbumTestDataBuilder {
        this.numElements = numElements
        return this
    }


    fun buildList(): List<AlbumModel> {
        val list = mutableListOf<AlbumModel>()

        for(i in 0 until numElements) {
            list.add(
                AlbumModel(
                    id,
                    name = name,
                    images = images
                )
            )
        }

        return list.toList()
    }


    fun buildSingle() = listOf(
        AlbumModel(
        id = id,
        name = name,
        images = images),
    )
}