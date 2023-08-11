package com.example.wondermusic.presentation.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wondermusic.domain.model.AlbumModel
import com.example.wondermusic.domain.model.ArtistModel
import com.example.wondermusic.domain.usecase.GetDetailUseCase
import com.example.wondermusic.domain.usecase.GetTopTracksUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(
    private val getDetailUseCase: GetDetailUseCase,
    private val getTopTracksUseCase: GetTopTracksUseCase
    ):ViewModel() {
    private val _artist = MutableLiveData<ArtistModel>()
    val artist: LiveData<ArtistModel> get() = _artist

    private val _tracksList = MutableLiveData<List<AlbumModel>>()
    val tracksList: LiveData<List<AlbumModel>> get() = _tracksList

    private val _errorMessage = MutableLiveData<String?>()
    val errorMessage: LiveData<String?> get() = _errorMessage


    fun getArtist(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                getDetailUseCase.invoke(id)
            }
            _artist.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }


    fun getTopTracks(id: String) = viewModelScope.launch {
        try {
            val result = withContext(Dispatchers.IO) {
                when(id){
                    "2IMZYfNi21MGqxopj9fWx8" -> getTopTracksUseCase.invokeRelsB(id)
                    "7ltDVBr6mKbRvohxheJ9h1" -> getTopTracksUseCase.invokeRosalia(id)
                    "6k8mwkKJKKjBILo7ypBspl" -> getTopTracksUseCase.invokeAnaMena(id)
                    "4F4pp8NUW08JuXwnoxglpN" -> getTopTracksUseCase.invokeBadgyal(id)
                    "26VFTg2z8YR0cCuwLzESi2" -> getTopTracksUseCase.invokeHalsey(id)
                    "6qqNVTkY8uBg9cP3Jd7DAH" -> getTopTracksUseCase.invokeBillie(id)
                    "1HY2Jd0NmPuamShAr6KMms" -> getTopTracksUseCase.invokeLadyGaga(id)
                    "2CIMQHirSU0MQqyYHq0eOx" -> getTopTracksUseCase.invokeDeadmau(id)
                    "57dN52uHvrHOxijzpIgu3E" -> getTopTracksUseCase.invokeRatata(id)
                    "1vCWHaC5f2uS3yhpwWbIA6" -> getTopTracksUseCase.invokeAvicii(id)

                    else -> {
                        getTopTracksUseCase.invokeRelsB(id)
                    }
                }
            }
            _tracksList.value = result
        } catch (_: Throwable) {
            _errorMessage.value = "Error lunched from ViewModel"
        }
    }

}