package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ahmed.m.hassaan.core.viewmodel.BaseViewModel
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.usecases.CacheImagesUseCase
import com.ahmed.m.hassaan.domain.usecases.FetchPhotoUseCase
import com.ahmed.m.hassaan.domain.usecases.GetCachedImageUseCase
import com.ahmed.m.hassaan.nasaimages.app.App
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val fetchPhotoUseCase: FetchPhotoUseCase,
    private val cacheImagesUseCase: CacheImagesUseCase,
    private val getCashedImagesUseCase: GetCachedImageUseCase
) :
    BaseViewModel() {

    private val _images: MutableStateFlow<List<DomainNasaImage>> = MutableStateFlow(emptyList())
    val images get() = _images as StateFlow<List<DomainNasaImage>>

    private val _pagination: MutableStateFlow<List<DomainNasaImage>> = MutableStateFlow(emptyList())
    val paginatedImages get() = _pagination as StateFlow<List<DomainNasaImage>>


    private var page: Int = 1

    private var keyword = ""


    private val _errorLiveData = MutableLiveData<String>()
    val errorLiveData: LiveData<String> = _errorLiveData

    private val _paginationProgress = MutableLiveData<Boolean>()
    val paginationProgress: LiveData<Boolean> = _paginationProgress

    private val _loadingDataProgress = MutableLiveData<Boolean>(true)
    val loadingDataProgress: LiveData<Boolean> = _loadingDataProgress

    init {
//        _loadingDataProgress.postValue(true)
//        getFirstPageImagesFromCache()
        getFirstImagesByKeyword("")
    }

    private fun getFirstPageImagesFromCache() {
        getCashedImagesUseCase.execute(
            GetCachedImageUseCase.Request(1)
        ).dataHandling(
            success = {
                _loadingDataProgress.postValue(false)
                _images.value = it
                Log.d(App.APP_TAG, "HomeViewModel - getFirstPageImagesFromCache:  data from cache is $it")
                
            },
            showLoading = {
                _loadingDataProgress.postValue(true)
            },
            showError = {
                _errorLiveData.postValue(it.message)
            }
        )
    }

    private fun cacheImages(page: Int, it: List<DomainNasaImage>) {
        cacheImagesUseCase.execute(CacheImagesUseCase.Request(it)).dataHandling(
            success = {
                Log.d(App.APP_TAG, "HomeViewModel - cacheImages:  data saved in room")
            },
            showError = {
                Log.d(App.APP_TAG, "HomeViewModel - cacheImages:  error in saving is $it")
            },
            
        )
    }

    fun getFirstImagesByKeyword(keyword: String) {
        this.keyword = keyword

        fetchPhotoUseCase.execute(
            FetchPhotoUseCase.Request(keyword, 1)
        ).dataHandling(
            success = {
                _loadingDataProgress.postValue(false)
                Log.d(App.APP_TAG, "HomeViewModel - getFirstImagesByKeyword:  data is Ok with $it")
                _images.value = it

                cacheImages(page, it)
            },
            showError = {
                if (it is NetworkErrorException)
                    getFirstPageImagesFromCache()
                else
                    _errorLiveData.postValue(it.message)

            },
            showLoading = {
                _loadingDataProgress.postValue(true)
            }
        )
    }

    fun paginate() {
        page++

        fetchPhotoUseCase.execute(
            FetchPhotoUseCase.Request(keyword, page)
        ).dataHandling(
            success = {
                _paginationProgress.postValue(false)
                Log.d(App.APP_TAG, "HomeViewModel - getFirstImagesByKeyword:  data is Ok with $it")
                _pagination.value = it
            },
            showLoading = {
                _paginationProgress.postValue(it)
            }
        )
    }


}