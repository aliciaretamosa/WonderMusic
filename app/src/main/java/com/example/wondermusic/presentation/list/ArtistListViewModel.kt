package com.example.wondermusic.presentation.list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.usecase.GetArtistListUseCase
import com.example.wondermusic.domain.usecase.MakeArtistFavoriteUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtistListViewModel(
    private val getArtistListUseCase: GetArtistListUseCase,
    private val makeArtistFavoriteUseCase: MakeArtistFavoriteUseCase
):ViewModel() {
    private val _artistList = MutableLiveData<List<ArtistModel>>()
    val artistList: LiveData<List<ArtistModel>> get() = _artistList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData(){
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getArtistListUseCase.invoke()
                }
                _artistList.value = result
                Log.d("LISTA ARTISTAS","${artistList.value?.size}")
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }

    fun makeArtistFavorite(id: String, state: Boolean) {
        viewModelScope.launch {
            try {
                _errorMessage.value = null
                makeArtistFavoriteUseCase.invoke(id, state)
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }


}