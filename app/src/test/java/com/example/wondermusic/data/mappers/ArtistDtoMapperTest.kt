package com.keepcoding.androidsuperpoderes.data.mappers

import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.FollowersLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.data.mappers.toArtistLocal
import com.example.wondermusic.data.mappers.toArtistModel
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.FollowersDto
import com.example.wondermusic.data.remote.dto.ImagesDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class ArtistDtoMapperTest {

    @Test
    fun `WHEN toArtistModel with values EXPECT model has value id`() {
        val artistDto = ArtistDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            followers = FollowersDto(10),
            genres = listOf()
        )
        val res = artistDto.toArtistModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toArtistModel with values EXPECT model has value name`() {
        val artistDto = ArtistDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            followers = FollowersDto(10),
            genres = listOf()
        )
        val res = artistDto.toArtistModel()

        assertThat(res.name, `is`("Sample Name"))
    }

    @Test
    fun `WHEN toArtistModel with null EXPECT empty string`() {
        val artistDto = ArtistDto(
            id = null,
            name = null,
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            followers = FollowersDto(0),
            genres = listOf()
        )
        val res = artistDto.toArtistModel()

        assertThat(res.id, `is`(""))
    }

    @Test
    fun `WHEN toArtistLocal with values EXPECT model has value`() {
        val artistDto = ArtistDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            followers = FollowersDto(10),
            genres = listOf()
        )
        val res = artistDto.toArtistLocal()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toArtistLocal with null EXPECT empty string`() {
        val artistDto = ArtistDto(
            id = null,
            name = null,
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            followers = FollowersDto(0),
            genres = listOf()
        )
        val res = artistDto.toArtistLocal()

        assertThat(res.id, `is`(""))
    }

    @Test
    fun `WHEN artistLocaltoArtistModel with values EXPECT model has value`() {
        val artistLocal = ArtistLocal(
            id = "test-id",
            name = "Sample Name",
            image = ImagesLocal(0,"",0),
            followers = FollowersLocal(10),
            genres = listOf(),
            favorite = false
        )
        val res = artistLocal.toArtistModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN artistLocaltoArtistModel with null EXPECT empty string`() {
        val artistLocal = ArtistLocal(
            id = "",
            name = "Sample Name",
            image = ImagesLocal(0,"",0),
            followers = FollowersLocal(10),
            genres = listOf(),
            favorite = false
        )
        val res = artistLocal.toArtistModel()

        assertThat(res.id, `is`(""))
    }
}