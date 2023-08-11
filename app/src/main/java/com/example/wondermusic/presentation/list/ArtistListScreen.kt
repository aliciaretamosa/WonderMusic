package com.example.wondermusic.presentation.list

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.wondermusic.components.AboutActionIcon
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.ui.theme.Green
import com.example.wondermusic.ui.theme.LightPastelPink
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ArtistListScreen(
    artistListViewModel: ArtistListViewModel = koinViewModel(),
    navController: NavController,
    onItemClick: (String) -> Unit
) {
    val state = artistListViewModel.artistList.observeAsState()

    val errorState = artistListViewModel.errorMessage.observeAsState()

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                title = { Text(text = "Listado de artistas") },
                actions = { AboutActionIcon(navController) })
        }
    ) {
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Fixed(2),
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(listOf(LightPastelPink, Green)))
                .padding(
                    bottom = 55.dp,
                ),
            horizontalArrangement = Arrangement.spacedBy(2.dp)
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

}
