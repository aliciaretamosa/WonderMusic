package com.example.wondermusic.presentation.list

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.ui.theme.LightPastelPink
import com.example.wondermusic.ui.theme.PastelPink
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArtistListScreen(
    artistListViewModel: ArtistListViewModel = koinViewModel(),
    onItemClick: (String) -> Unit
) {
    val state = artistListViewModel.artistList.observeAsState()

    val errorState = artistListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Fixed(2),
        modifier = Modifier
        .padding(
            bottom = 70.dp,
        )
            .background(Color.LightGray),
    horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
            val artistList = state.value
            items(artistList?.size ?: 0) { i ->
                // Unwrap
                val item = artistList?.get(i)
                item?.let { artist ->
                    ShowArtistList(artist) {
                        onItemClick.invoke(artist.id)
                    }
                }
            }
    }
}

@Preview
@Composable
fun ArtistListScreenPreview() {
    ArtistListScreen {
        // Empty callback
    }
}