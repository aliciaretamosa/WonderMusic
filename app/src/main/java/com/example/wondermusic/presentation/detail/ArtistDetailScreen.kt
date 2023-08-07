package com.example.wondermusic.presentation.detail

import android.annotation.SuppressLint
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import com.example.wondermusic.components.ShowError
import org.koin.androidx.compose.koinViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ArtistDetailScreen(
    id: String,
    heroDetailViewModel: DetailViewModel = koinViewModel(),
    onBack: () -> Unit
) {
    val heroState = heroDetailViewModel.artist.observeAsState()
    val errorState = heroDetailViewModel.errorMessage.observeAsState()

    heroDetailViewModel.getHero(id)

    if (errorState.value?.isNotEmpty() == true) {
        val error = errorState.value
        ShowError(error = error ?: "")
    }

    val result = heroState.value

    // Side Effects
    // Mutabilidad
    result?.let { artist ->
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text("Detalle de ${ artist.name }")
                    },
                    navigationIcon = {
                        IconButton(
                            modifier = Modifier.semantics {
                                contentDescription = "Atrás Botón Ir al listado de personajes"
                            },
                            onClick = onBack
                        ) {
                            Icon(Icons.Filled.ArrowBack, null)
                        }
                    }
                )
            }
        ) {
            ShowArtistDetail(artist = artist)
        }
    } ?: run {
        ShowError("Unknown error")
    }
}