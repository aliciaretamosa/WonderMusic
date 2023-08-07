package com.example.wondermusic.presentation.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.wondermusic.domain.model.ArtistModel

val requester = FocusRequester()

@Composable
fun ShowArtistDetail(
    artist: ArtistModel
) {
    var starred by remember {
        mutableStateOf(false)
    }

    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        /*AsyncImage(
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.ball),
            error = painterResource(id = R.drawable.ball),
            model = ImageRequest.Builder(LocalContext.current)
                .data(artist.photoUrl)
                .build(),
            contentDescription = "Personaje ${hero.name} Imagen"
        )*/
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = artist.name,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = artist.followers.total.toString(),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = artist.genres.toString(),
                    maxLines = 4,
                    overflow = TextOverflow.Ellipsis
                )
            }

            // Star
            // Gestionar la semántica y los cambios de estado
            Checkbox(
                modifier = Modifier
                    .clearAndSetSemantics {
                        //.semantics {
                        contentDescription = "Hacer ${artist.name} Favorito"
                        stateDescription = if (starred) {
                            "${artist.name} marcado como Favorito"
                        } else {
                            "${artist.name} desmarcado como Favorito"
                        }
                    },
                checked = starred,
                onCheckedChange = {
                    starred = it
                }
            )
        }
        /*
        LaunchedEffect(Unit) {
            this.coroutineContext.job.invokeOnCompletion {
                requester.requestFocus()
            }
        }*/
    }
}