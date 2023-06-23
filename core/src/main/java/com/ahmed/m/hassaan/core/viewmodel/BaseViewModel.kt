package com.ahmed.m.hassaan.core.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.m.hassaan.domain.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject



open class BaseViewModel :  ViewModel() {

    inline fun <T> Flow<Resource<T>>.dataHandling(

        isShowError:Boolean = false,
        isShowLoading: Boolean = false,
        crossinline success:(data:T) -> Unit,
        crossinline showLoading: () -> Unit = {},
        crossinline showError: () -> Unit = {}
    ):Job{
        return this.onEach {
            when (it) {
                is Resource.Success -> {
                    success.invoke(it.data)
                }
                is Resource.Loading -> {
                    showLoading.invoke()
                }
                is Resource.Error -> {
                    showError.invoke()
                }
            }
        }.launchIn(viewModelScope)
    }
}