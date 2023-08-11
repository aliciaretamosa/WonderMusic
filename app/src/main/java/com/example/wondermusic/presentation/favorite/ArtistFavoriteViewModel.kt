package com.example.wondermusic.presentation.favorite

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.usecase.GetArtistFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtistFavoriteViewModel(
    private val getArtistFavoriteUseCase: GetArtistFavoriteUseCase
):ViewModel() {

    private val _favoriteList = MutableLiveData<List<ArtistModel>>()
    val favoriteList: LiveData<List<ArtistModel>> get() = _favoriteList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    fun getFavoriteArtists() {
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getArtistFavoriteUseCase.invoke()
                }
                _favoriteList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }

}