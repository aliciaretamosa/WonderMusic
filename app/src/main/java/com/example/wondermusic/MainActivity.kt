package com.example.wondermusic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.wondermusic.navigation.NavigationGraph
import com.example.wondermusic.ui.theme.WonderMusicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WonderMusicTheme {
                    NavigationGraph()
            }
        }
    }
}
