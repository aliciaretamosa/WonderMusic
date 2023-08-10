package com.example.wondermusic.presentation.detail

import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.wondermusic.R
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.ui.theme.globalPadding

@Composable
fun ShowTrackList(
    track: AlbumModel
) {
    Box {
        AsyncImage(
            modifier = Modifier
                .size(160.dp)
                .padding(globalPadding)
                .clip(CircleShape)
                .focusRequester(focusRequester = requester)
                .focusable(),
            placeholder = painterResource(id = R.drawable.foto),
            error = painterResource(id = R.drawable.foto),
            model = ImageRequest.Builder(LocalContext.current)
                .data(track.images.url)
                .build(),
            contentDescription = "Canción ${track.name} Imagen"
        )
        Text(
            modifier = Modifier
                .width(150.dp)
                .align(Alignment.BottomStart)
                .padding(start = 20.dp, bottom = 50.dp),
            text = track.name,
            fontWeight = FontWeight.Bold,
            fontSize = 15.sp,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            color = Color.White
        )
    }

}