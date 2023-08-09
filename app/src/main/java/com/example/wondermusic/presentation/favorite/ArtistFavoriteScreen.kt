package com.example.wondermusic.presentation.favorite

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
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
import com.example.wondermusic.presentation.favorite.ShowArtistFavorite
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@Composable
fun ArtistFavoriteScreen(
    artistFavoriteViewModel: ArtistFavoriteViewModel = koinViewModel(),
) {

    artistFavoriteViewModel.getFavoriteArtists()

    val state = artistFavoriteViewModel.favoriteList.observeAsState()

    val errorState = artistFavoriteViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyColumn(
        modifier = Modifier
            .padding(
                vertical = globalPadding
            ),
        verticalArrangement = Arrangement.Center
    ) {
        val favoriteList = state.value
        items(favoriteList?.size ?: 0) { i ->
            // Unwrap
            val item = favoriteList?.get(i)
            item?.let { artist ->
                ShowArtistFavorite(artist) {
                }
            }
        }

    }
}


@Preview
@Composable
fun ArtistListScreenPreview() {
    ArtistFavoriteScreen ()
}