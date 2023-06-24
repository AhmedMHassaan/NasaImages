package com.ahmed.m.hassaan.domain.usecases

import com.ahmed.m.hassaan.domain.BaseFlowUseCase
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.model.Resource
import com.ahmed.m.hassaan.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CacheImagesUseCase @Inject constructor(
    private val localRepository: LocalRepository,

    ) : BaseFlowUseCase<CacheImagesUseCase.Request, Unit>() {


    override fun execute(request: Request): Flow<Resource<Unit>> {
        return flow {
            emit(Resource.Success(localRepository.saveLocalItems(request.imagesList)))
        }
    }

    data class Request(
        val imagesList: List<DomainNasaImage>
    )
}