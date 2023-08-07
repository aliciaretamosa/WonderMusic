package com.example.wondermusic.presentation.favorite

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.presentation.list.ArtistListViewModel
import com.example.wondermusic.presentation.list.ShowArtistList
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArtistFavoriteScreen(
    //artistFavoriteViewModel: ArtistFavoriteViewModel = koinViewModel(),
) {
   Text("FAVORITOS")
}

@Preview
@Composable
fun ArtistListScreenPreview() {
    ArtistFavoriteScreen ()
}