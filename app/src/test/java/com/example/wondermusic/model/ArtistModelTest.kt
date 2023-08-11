package com.keepcoding.androidsuperpoderes.domain.model

import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.model.FollowersModel
import com.example.wondermusic.domain.model.ImagesModel
import org.hamcrest.CoreMatchers.instanceOf
import org.hamcrest.MatcherAssert.*
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.CoreMatchers.notNullValue
import org.junit.Test

class ArtistModelTest {

    //
    var artistModel = ArtistModel(
        "56",
        "Alex",
        ImagesModel(10,"https://",10),
        FollowersModel(10),
        listOf(),
        false
    )

    @Test
    fun `WHEN create model EXPECT not null value`() {
        assertThat(artistModel, instanceOf(ArtistModel::class.java))
        assertThat(artistModel, notNullValue())
    }

    @Test
    fun `WHEN artistModel id is 56 EXPECT id = 56`() {
        val artist = ArtistTestDataBuilder()
            .buildSingle()
        assertThat(artist.id, `is`("test-id"))
    }

    @Test
    fun `WHEN artistModel name is Alex EXPECT name = Alex`() {
        val artist = ArtistTestDataBuilder()
            .withName("Alex")
            .buildSingle()
        assertThat(artist.name, `is`("Alex"))
    }

    @Test
    fun `WHEN creates artistModel EXPECT photoUrl contains schema`() {
        assertThat(artistModel.images.url, artistModel.images.url.startsWith("https"))
    }

}