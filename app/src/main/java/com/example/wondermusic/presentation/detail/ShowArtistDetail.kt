package com.example.wondermusic.presentation.detail

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wondermusic.R
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.ui.theme.Green
import com.example.wondermusic.ui.theme.LightPastelPink
import com.example.wondermusic.ui.theme.PastelPink
import com.example.wondermusic.ui.theme.globalRoundedCornerShape
import org.koin.androidx.compose.koinViewModel

val requester = FocusRequester()

@Composable
fun ShowArtistDetail(
    artist: ArtistModel,
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
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Brush.horizontalGradient(listOf(LightPastelPink, Green)))
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(modifier = Modifier
            .padding(8.dp)) {
            Spacer(modifier = Modifier
                .size(25.dp))
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
                contentDescription = "Artista ${artist.name}"
            )
        }
       Row(modifier = Modifier
           .fillMaxHeight()
       ) {
           Column(
               verticalArrangement = Arrangement.Center,
               horizontalAlignment = Alignment.CenterHorizontally) {
               Row(verticalAlignment = Alignment.CenterVertically
               ) {
                   Text(
                       text = artist.name,
                       color = Color.White,
                       fontSize = 50.sp,
                       fontWeight = FontWeight.ExtraBold,
                       maxLines = 1,
                       overflow = TextOverflow.Ellipsis
                   )
                   Spacer(modifier = Modifier
                       .size(15.dp))

                   if(artist.favorite){
                       Card(modifier = Modifier
                           .padding(top = 20.dp),
                           border = BorderStroke(1.dp, PastelPink),
                           backgroundColor = LightPastelPink,
                           shape = RoundedCornerShape(globalRoundedCornerShape)
                       ) {
                           Text(modifier = Modifier
                               .width(70.dp),
                               text = "Favorito",
                               textAlign = TextAlign.Center,
                               color = Color.Gray,
                               fontSize = 15.sp,
                               maxLines = 1,
                               overflow = TextOverflow.Ellipsis
                           )
                       }
                   }
               }

               Spacer(modifier = Modifier
                   .size(2.dp))
               Text(
                   text = artist.followers.total.toString() + " seguidores",
                   color = Color.DarkGray,
                   maxLines = 4,
                   overflow = TextOverflow.Ellipsis
               )
               Spacer(modifier = Modifier
                   .size(20.dp))
               Text(
                   modifier = Modifier.padding(start= 70.dp, end = 60.dp),
                   text = artist.genres.toString(),
                   fontSize = 15.sp,
                   maxLines = 4,
                   overflow = TextOverflow.Ellipsis
               )

               Spacer(modifier = Modifier
                   .size(60.dp))

               Text(modifier = Modifier
                   .align(Alignment.Start)
                   .padding(start = 20.dp),
                   color = Color.White,
                   text = "Top Tracks",
                   fontSize = 25.sp)

               Spacer(modifier = Modifier
                   .size(25.dp))

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
}