package com.example.wondermusic.presentation.start

import androidx.compose.runtime.Composable
import androidx.compose.ui.viewinterop.AndroidViewBinding
import com.example.wondermusic.databinding.StartScreenBinding

@Composable
fun StartScreen(
    onClick:() -> Unit
) {
    AndroidViewBinding(factory = StartScreenBinding::inflate){
        imageView.setOnClickListener {
            onClick()
        }
    }
}