package com.ahmed.m.hassaan.domain

import com.ahmed.m.hassaan.domain.model.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart

abstract class BaseFlowUseCase<in REQUEST, RESULT> {

    abstract fun execute(request: REQUEST): Flow<Resource<RESULT>>

    open fun invoke(request: REQUEST) =
        execute(request)
            .onStart {
                emit(Resource.Loading(true))
            }
            .onCompletion {
                emit(Resource.Loading(false))
            }
            .catch {
                emit(Resource.Error(error = it))
            }


}