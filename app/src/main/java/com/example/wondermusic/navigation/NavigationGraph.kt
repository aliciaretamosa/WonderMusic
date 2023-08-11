package com.example.wondermusic.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.wondermusic.R
import com.example.wondermusic.ui.theme.PastelPink


sealed class BottomNavigationScreens(val route: String, val title: String, val icon: ImageVector) {
    object Home : BottomNavigationScreens("artistList", "Home", Icons.Filled.Home)
    object Favoritos : BottomNavigationScreens("artistFavorite", "Favoritos", Icons.Filled.Favorite)
}


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun NavigationGraph() {
    val navController = rememberNavController()

    val screens = listOf(
        Screen.ArtistListScreen,
        Screen.ArtistFavoriteScreen,
    )

    val showBottomBar = navController
        .currentBackStackEntryAsState().value?.destination?.route in screens.map { it.route }

    Scaffold(
        bottomBar = {
            if(showBottomBar) BottomNavigation(navController = navController)
        }
    ) {
        NavHost( // FragmentContainerView
            navController = navController,
            startDestination = Screen.StartScreen.route, // Igual que el startDestination
        ) {
            addStartScreen(navController)
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
        backgroundColor = colorResource(id = R.color.white),
        contentColor = Color.Black,
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(15.dp, 15.dp, 0.dp, 0.dp))
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(modifier = Modifier
                //.background(LightPastelPink)
                .padding(top = 30.dp),
                icon = { Icon(
                    item.icon,
                    contentDescription = item.title,
                    modifier = Modifier
                        .size(30.dp),
                    tint = if(item.route == currentRoute) PastelPink else Color.Gray
                )
                       },
                label = { Text(
                    if(item.route == currentRoute) item.title else "",
                    fontSize = 9.sp
                ) },
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

@Preview
@Composable
fun BottomNavigationPreview() {
    val navController = rememberNavController()
    BottomNavigation {
        // Empty callback
    }
}