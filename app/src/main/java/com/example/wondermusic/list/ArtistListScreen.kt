package com.example.wondermusic.list

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

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

    LazyColumn(
    modifier = Modifier.padding(
    vertical = globalPadding
    ),
    horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val heroList = state.value
        items(heroList?.size ?: 0) { i ->
            // Unwrap
            val item = heroList?.get(i)
            item?.let { hero ->
                ShowArtistList(hero) {
                    onItemClick.invoke(hero.id)
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