package com.example.wondermusic.presentation.favorite

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.navigation.NavController
import com.example.wondermusic.components.AboutActionIcon
import com.example.wondermusic.components.ShowError
import com.example.wondermusic.ui.theme.Green
import com.example.wondermusic.ui.theme.LightPastelPink
import com.example.wondermusic.ui.theme.globalPadding
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ArtistFavoriteScreen(
    artistFavoriteViewModel: ArtistFavoriteViewModel = koinViewModel(),
    navController: NavController,
    onItemClick: (String) -> Unit
) {

    artistFavoriteViewModel.getFavoriteArtists()

    val state = artistFavoriteViewModel.favoriteList.observeAsState()

    val errorState = artistFavoriteViewModel.errorMessage.observeAsState()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior(rememberTopAppBarState())

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                backgroundColor = MaterialTheme.colors.surface,
                title = { Text(text = "Artistas favoritos") },
                actions = { AboutActionIcon(navController) })
        }
    ) {innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Brush.horizontalGradient(listOf(LightPastelPink, Green)))
            .padding(
                    vertical = globalPadding
                )
                .padding(innerPadding),
        ) {
            val favoriteList = state.value
            items(favoriteList?.size ?: 0) { i ->
                // Unwrap
                val item = favoriteList?.get(i)
                item?.let { artist ->
                    ShowArtistFavorite(artist) {
                        onItemClick.invoke(artist.id)
                    }
                }
            }

        }
    }


}
