package com.keepcoding.androidsuperpoderes.data.mappers

import com.example.wondermusic.data.local.model.AlbumLocal
import com.example.wondermusic.data.local.model.ArtistLocal
import com.example.wondermusic.data.local.model.FollowersLocal
import com.example.wondermusic.data.local.model.ImagesLocal
import com.example.wondermusic.data.mappers.toAlbumLocal
import com.example.wondermusic.data.mappers.toAlbumModel
import com.example.wondermusic.data.mappers.toArtistLocal
import com.example.wondermusic.data.mappers.toArtistModel
import com.example.wondermusic.data.remote.dto.AlbumDto
import com.example.wondermusic.data.remote.dto.ArtistDto
import com.example.wondermusic.data.remote.dto.FollowersDto
import com.example.wondermusic.data.remote.dto.ImagesDto
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test

class AlbumDtoMapperTest {

    @Test
    fun `WHEN toAlbumModel with values EXPECT model has value id`() {
        val albumDto = AlbumDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
        )
        val res = albumDto.toAlbumModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN toAlbumModel with values EXPECT model has value name`() {
        val albumDto = AlbumDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
        )
        val res = albumDto.toAlbumModel()

        assertThat(res.name, `is`("Sample Name"))
    }

    @Test
    fun `WHEN toAlbumModel with null EXPECT empty string`() {
        val albumDto = AlbumDto(
            id = "",
            name = "",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
        )
        val res = albumDto.toAlbumModel()

        assertThat(res.id, `is`(""))
    }

    @Test
    fun `WHEN toAlbumLocal with values EXPECT model has value`() {
        val albumDto = AlbumDto(
            id = "test-id",
            name = "Sample Name",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
            )
        val res = albumDto.toAlbumLocal()

        assertThat(res.albumId, `is`("test-id"))
    }

    @Test
    fun `WHEN toAlbumLocal with null EXPECT empty string`() {
        val albumDto = AlbumDto(
            id = "",
            name = "",
            images = listOf(ImagesDto(0,"",0), ImagesDto(0,"",0)),
        )
        val res = albumDto.toAlbumLocal()

        assertThat(res.albumId, `is`(""))
    }

    @Test
    fun `WHEN albumLocaltoAlbumModel with values EXPECT model has value`() {
        val albumLocal = AlbumLocal(
            albumId = "test-id",
            name = "Sample Name",
            image = ImagesLocal(0,"",0),
            artistId = ""
        )
        val res = albumLocal.toAlbumModel()

        assertThat(res.id, `is`("test-id"))
    }

    @Test
    fun `WHEN albumLocaltoAlbumModel with null EXPECT empty string`() {
        val albumLocal = AlbumLocal(
            albumId = "",
            name = "Sample Name",
            image = ImagesLocal(0,"",0),
            artistId = ""
        )
        val res = albumLocal.toAlbumModel()

        assertThat(res.id, `is`(""))
    }
}