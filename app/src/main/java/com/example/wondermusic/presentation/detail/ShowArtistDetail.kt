package com.example.wondermusic.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.stateDescription
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wondermusic.R
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.components.StarComponent
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.presentation.list.ArtistListViewModel
import com.example.wondermusic.ui.theme.PastelPink
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

val requester = FocusRequester()

@Composable
fun ShowArtistDetail(
    artist: ArtistModel,
    artistListViewModel: ArtistListViewModel = koinViewModel(),
    artistDetailViewModel: DetailViewModel = koinViewModel(),
    ) {

    var starred by remember {
        mutableStateOf(false)
    }

    val state = artistDetailViewModel.tracksList.observeAsState()
    val errorState = artistDetailViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    Column(
        modifier = Modifier
            .fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(modifier = Modifier
            .padding(8.dp)) {
            Spacer(modifier = Modifier
                .size(20.dp))
            AsyncImage(
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .focusRequester(focusRequester = requester)
                    .focusable(),
                placeholder = painterResource(id = R.drawable.foto),
                error = painterResource(id = R.drawable.foto),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(artist.images.url)
                    .build(),
                contentDescription = "Personaje ${artist.name} Imagen"
            )
        }
       Row(modifier = Modifier
           .fillMaxHeight()
       ) {
           Column(verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally) {
               Spacer(modifier = Modifier
                   .size(40.dp))
               Row() {
                   Text(
                       text = artist.name,
                       fontSize = 30.sp,
                       maxLines = 1,
                       overflow = TextOverflow.Ellipsis
                   )
                   AndroidView(
                       modifier = Modifier.clickable {
                           val newState = !starred
                           starred = newState
                       },
                       factory = { context ->
                           StarComponent(context).apply {
                               this.checked = starred
                           }
                       },
                       update = {
                           it.checked = artist.favorite
                           if(starred) { //guardar en favoritos
                               artistListViewModel.makeArtistFavorite(artist.id,true)
                           } else {
                               artistListViewModel.makeArtistFavorite(artist.id,false)
                           }
                       }
                   )
               }
               Spacer(modifier = Modifier
                   .size(10.dp))
               Text(
                   text = artist.followers.total.toString() + " seguidores",
                   maxLines = 4,
                   overflow = TextOverflow.Ellipsis
               )
               Spacer(modifier = Modifier
                   .size(20.dp))
               Text(
                   modifier = Modifier.padding(30.dp),
                   text = artist.genres.toString(),
                   maxLines = 4,
                   overflow = TextOverflow.Ellipsis
               )

               LazyRow(
                   modifier = Modifier
                       .padding(
                           bottom = 70.dp,
                       )
               ) {
                   val trackList = state.value
                   items(5) {i ->
                       val item = trackList?.get(i)
                       item?.let { track ->
                           ShowTrackList(track)
                       }
                   }

               }

           }

       }

    }
        /*
        LaunchedEffect(Unit) {
            this.coroutineContext.job.invokeOnCompletion {
                requester.requestFocus()
            }
        }*/
}