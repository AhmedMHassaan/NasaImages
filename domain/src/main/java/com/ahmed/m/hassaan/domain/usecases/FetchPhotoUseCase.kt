package com.ahmed.m.hassaan.domain.usecases

import android.util.Log
import com.ahmed.m.hassaan.domain.BaseFlowUseCase
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.model.Resource
import com.ahmed.m.hassaan.domain.repository.RemoteImagesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FetchPhotoUseCase @Inject constructor(
    private val remoteRepository: RemoteImagesRepository
) : BaseFlowUseCase<FetchPhotoUseCase.Request, List<DomainNasaImage>>() {


    override fun execute(request: Request): Flow<Resource<List<DomainNasaImage>>> =
        flow {
            val response = remoteRepository.getData(
                request.keyword,
                request.page
            )

            Log.d("APP_TAG", "FetchPhotoUseCase - execute:  response")
            emit(Resource.Success(response))
        }


    data class Request(
        val keyword: String,
        val page: Int
    )
}