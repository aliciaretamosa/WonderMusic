package com.example.wondermusic.detail

import androidx.lifecycle.ViewModel
import com.example.wondermusic.domain.usecase.GetDetailUseCase

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
):ViewModel() {
}