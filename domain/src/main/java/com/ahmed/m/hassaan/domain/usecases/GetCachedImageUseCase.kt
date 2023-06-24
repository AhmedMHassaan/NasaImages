package com.ahmed.m.hassaan.domain.usecases

import android.util.Log
import com.ahmed.m.hassaan.domain.BaseFlowUseCase
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.model.Resource
import com.ahmed.m.hassaan.domain.repository.LocalRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.launchIn
import javax.inject.Inject

class GetCachedImageUseCase @Inject constructor(
    private val localRepository: LocalRepository
) : BaseFlowUseCase<GetCachedImageUseCase.Request, List<DomainNasaImage>>() {


    data class Request(
        private val pageNumber: Int
    )

    override fun execute(request: Request): Flow<Resource<List<DomainNasaImage>>> {
        return flow {
            val response = localRepository.getData()
//            Log.d("APP_TAG", "GetCachedImageUseCase - execute:  data from cache is $response")
            emit(Resource.Success(response))
        }
    }


}