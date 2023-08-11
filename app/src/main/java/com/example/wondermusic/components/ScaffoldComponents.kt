package com.example.wondermusic.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun NavigationIcon(navController: NavController) {
    if (navController.previousBackStackEntry != null) {
        IconButton(
            onClick = { navController.navigateUp() }) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back"
            )
        }
    }
}

@Composable
fun AboutActionIcon(navController: NavController) {
    IconButton(
        onClick = {  }) {
        /*
        Icon(
            imageVector = Icons.Filled.Info,
            contentDescription = "About"
        )*/
    }
}