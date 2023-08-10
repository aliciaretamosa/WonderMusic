package com.example.wondermusic.presentation.favorite

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
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
import com.example.wondermusic.presentation.list.ArtistListViewModel
import com.example.wondermusic.ui.theme.globalElevation
import com.example.wondermusic.ui.theme.globalPadding
import com.example.wondermusic.ui.theme.globalRoundedCornerShape
import org.koin.androidx.compose.koinViewModel

@Composable
fun ShowArtistFavorite(
    artist: ArtistModel,
    artistListViewModel: ArtistListViewModel = koinViewModel(),
    artistFavoriteViewModel: ArtistFavoriteViewModel = koinViewModel(),
    onClick: (() -> Unit)? = null
) {
    var starred by rememberSaveable { //remebersabable
        mutableStateOf(true)
    }

    if(artistFavoriteViewModel.getFavoriteArtists().toString().isEmpty()){
        Box(modifier = Modifier
            .fillMaxSize()){
            Text(
                text = "Agrega un favorito"
            )
        }
    }

    Card(
        modifier = Modifier.padding(globalPadding),
        elevation = globalElevation,
        shape = RoundedCornerShape(globalRoundedCornerShape)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
                .clickable {
                    if (onClick != null) {
                        onClick.invoke()
                    }
                },
            verticalAlignment = Alignment.CenterVertically
        ) {
            AsyncImage(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape),
                placeholder = painterResource(id = R.drawable.foto),
                error = painterResource(id = R.drawable.foto),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(artist.images.url)
                    .build(), contentDescription = ""
            )
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
                }

            }
        }
    }
}


@Composable
@Preview
fun ShowArtistPreview() {
    ShowArtistFavorite(
        ArtistTestDataBuilder()
            .withName("hola")
            .buildSingle()
    ) {
        // Nothing todo here
    }
}