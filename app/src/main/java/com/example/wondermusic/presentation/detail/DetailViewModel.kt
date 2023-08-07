package com.example.wondermusic.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase
):ViewModel() {
    private val _artist = MutableLiveData<ArtistModel>()
    val artist: LiveData<ArtistModel> get() = _artist

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun getHero(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _artist.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }
}