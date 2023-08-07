package com.example.wondermusic.navigation

import android.annotation.SuppressLint
import android.graphics.drawable.Icon
import androidx.annotation.StringRes
import androidx.compose.material.Icon
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wondermusic.R
import com.example.wondermusic.presentation.detail.ArtistDetailScreen
import com.example.wondermusic.presentation.list.ArtistListScreen


sealed class BottomNavigationScreens(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("artistList", "Home", Icons.Filled.Home)
    object Favoritos : BottomNavigationScreens("artistFavorite", "Favoritos", Icons.Filled.Favorite)
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = { BottomNavigation(navController = navController) }
    ) {
        NavHost( // FragmentContainerView
            navController = navController,
            startDestination = Screen.ArtistListScreen.route, // Igual que el startDestination
        ) {
            addArtistListScreen(navController)
            addArtistDetailScreen(navController)
            addArtistFavoriteScreen(navController)
        }
    }

}


@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(
        BottomNavigationScreens.Home,
        BottomNavigationScreens.Favoritos
    )
    BottomNavigation(
        backgroundColor = colorResource(id = R.color.teal_200),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
                selectedContentColor = Color.Black,
                unselectedContentColor = Color.Black.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}