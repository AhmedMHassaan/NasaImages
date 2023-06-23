package com.ahmed.m.hassaan.data.remote.datasources

import com.ahmed.m.hassaan.data.remote.api.SearchApiEndPoints
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RemoteDataSource @Inject constructor(
    private val nasaImagesService: SearchApiEndPoints
) {

    suspend fun fetchNasaImages(keyword: String, currentPage: Int) =
        nasaImagesService.searchByKeyword(keywords = keyword, currentPage = currentPage)
            .getOrThrow()



}