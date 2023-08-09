package com.example.wondermusic.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.example.wondermusic.presentation.detail.ArtistDetailScreen
import com.example.wondermusic.presentation.favorite.ArtistFavoriteScreen
import com.example.wondermusic.presentation.list.ArtistListScreen

fun NavGraphBuilder.addArtistListScreen(navController: NavHostController) {
    composable(Screen.ArtistListScreen.route) {
        ArtistListScreen { artistId ->
            navController.navigate("${Screen.ArtistDetailScreen.route}/$artistId")
        }
    }
}

fun NavGraphBuilder.addArtistDetailScreen(navController: NavHostController) {
    composable(
        route = Screen.ArtistDetailScreen.route + "/{artistId}",
        arguments = Screen.ArtistDetailScreen.arguments
    ) { navBackStackEntry ->
        val id = navBackStackEntry.arguments?.getString("artistId") ?: ""
        ArtistDetailScreen(id = id){
            navController.popBackStack()
        }
    }
}

fun NavGraphBuilder.addArtistFavoriteScreen(navController: NavHostController) {
    composable(Screen.ArtistFavoriteScreen.route) {
        ArtistFavoriteScreen()
    }
}
