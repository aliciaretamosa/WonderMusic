package com.example.wondermusic.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

sealed class Screen(
    val route: String,
    val arguments: List<NamedNavArgument>
) {
    object ArtistListScreen : Screen(
        route = "artistList",
        arguments = emptyList()
    )

    object ArtistDetailScreen : Screen(
        route = "artistDetail",
        arguments = listOf(
            navArgument("artistId") {
                type = NavType.StringType
                nullable = false
            }
        )
    )

    object ArtistFavoriteScreen : Screen(
        route = "artistFavorite",
        arguments = emptyList()
    )
}