package com.example.wondermusic.presentation.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.usecase.GetArtistListUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ArtistListViewModel(
    private val getArtistListUseCase: GetArtistListUseCase
):ViewModel() {
    private val _artistList = MutableLiveData<List<ArtistModel>>()
    val artistList: LiveData<List<ArtistModel>> get() = _artistList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            //examples.exampleFold()
            try {
                _errorMessage.value = null
                val result = withContext(Dispatchers.IO) {
                    getArtistListUseCase.invoke()
                }
                _artistList.value = result
            } catch (t: Throwable) {
                _errorMessage.value = "Error"
            }
        }
    }
}