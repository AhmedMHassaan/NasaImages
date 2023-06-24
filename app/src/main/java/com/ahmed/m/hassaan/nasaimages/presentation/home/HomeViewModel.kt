package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.util.Log
import com.ahmed.m.hassaan.core.viewmodel.BaseViewModel
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.usecases.FetchPhotoUseCase
import com.ahmed.m.hassaan.nasaimages.app.App
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(private val fetchPhotoUseCase: FetchPhotoUseCase) :
    BaseViewModel() {

    private val _images: MutableStateFlow<List<DomainNasaImage>> = MutableStateFlow(emptyList())
    val images get() = _images as StateFlow<List<DomainNasaImage>>

    private val _pagination: MutableStateFlow<List<DomainNasaImage>> = MutableStateFlow(emptyList())
    val paginatedImages get() = _pagination as StateFlow<List<DomainNasaImage>>


    private var page: Int = 1

    private var keyword = ""


    init {
//        getImagesFromCache()
    }

    fun getFirstImagesByKeyword(keyword: String) {
        this.keyword = keyword

        fetchPhotoUseCase.execute(
            FetchPhotoUseCase.Request(keyword, 1)
        ).dataHandling(
            success = {
                Log.d(App.APP_TAG, "HomeViewModel - getFirstImagesByKeyword:  data is Ok with $it")
                _images.value = it
            },
            showError = {
                Log.d(App.APP_TAG, "HomeViewModel - getFirstImagesByKeyword:  Error is ${it} ")
            },
            showLoading = {
                Log.d(
                    App.APP_TAG,
                    "HomeViewModel - getFirstImagesByKeyword:  progress loafing here"
                )
            }
        )
    }

    fun paginate() {
        page++

        fetchPhotoUseCase.execute(
            FetchPhotoUseCase.Request(keyword, page)
        ).dataHandling(
            success = {
                Log.d(App.APP_TAG, "HomeViewModel - getFirstImagesByKeyword:  data is Ok with $it")
                _pagination.value = it
            }
        )
    }


}