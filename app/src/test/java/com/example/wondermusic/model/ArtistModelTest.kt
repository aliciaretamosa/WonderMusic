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
    fun `WHEN heroModel id is 56 EXPECT id = 56`() {
        val hero = ArtistTestDataBuilder()
            .buildSingle()
        assertThat(hero.id, `is`("test-id"))
    }

    @Test
    fun `WHEN heroModel name is Alex EXPECT name = Alex`() {
        val hero = ArtistTestDataBuilder()
            .withName("Alex")
            .buildSingle()
        assertThat(hero.name, `is`("Alex"))
    }

    /**
     * Movido a StringExtTest
     */
    @Test
    fun `WHEN creates heroModel EXPECT photoUrl contains schema`() {
        //assertThat(heroModel.photoUrl, `is`("foto"))
        assertThat(artistModel.images.url, artistModel.images.url.startsWith("https"))
    }

}