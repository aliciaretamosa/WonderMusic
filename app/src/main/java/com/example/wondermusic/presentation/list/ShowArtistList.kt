package com.example.wondermusic.presentation.list

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wondermusic.ArtistTestDataBuilder
import com.example.wondermusic.R
import com.example.wondermusic.components.StarComponent
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.ui.theme.globalElevation
import com.example.wondermusic.ui.theme.globalPadding
import com.example.wondermusic.ui.theme.globalRoundedCornerShape
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShowArtistList(
    artist: ArtistModel,
    artistListViewModel: ArtistListViewModel = koinViewModel(),
    onClick: (() -> Unit)? = null
) {

    var starred by rememberSaveable { //remebersabable
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier
            .padding(globalPadding)
            .clickable {
                onClick?.invoke()
            },
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Column(modifier = Modifier
            .size(180.dp,150.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.foto),
                error = painterResource(id = R.drawable.foto),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(artist.images.url)
                    .build(), contentDescription = ""
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = artist.name,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )
                    // Star
                    AndroidView(
                        modifier = Modifier.clickable {
                            val newState = !starred
                            starred = newState
                        },
                        factory = { context ->
                            StarComponent(context).apply {
                                this.checked = artist.favorite
                                Log.d("hola","hola")
                            }
                        },
                        update = {
                            it.checked = starred
                            if(starred) { //guardar en favoritos
                                artistListViewModel.makeArtistFavorite(artist.id,true)
                            } else {
                                artistListViewModel.makeArtistFavorite(artist.id,false)
                            }
                        }
                    )
                }
            }
        }

    }
}


@Composable
@Preview
fun ShowArtistPreview() {
    ShowArtistList(
        ArtistTestDataBuilder()
            .withName("hola")
            .buildSingle()
    ) {
        // Nothing todo here
    }
}