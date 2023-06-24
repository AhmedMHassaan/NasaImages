package com.ahmed.m.hassaan.data.repository

import android.util.Log
import com.ahmed.m.hassaan.data.mapper.RemoteNasaItemMapper
import com.ahmed.m.hassaan.domain.repository.RemoteImagesRepository
import com.ahmed.m.hassaan.data.remote.datasources.RemoteDataSource
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val domainPhotoMapper: RemoteNasaItemMapper
) : RemoteImagesRepository {

    override suspend fun getData(keyword: String, page: Int): List<DomainNasaImage> {
        val response = remoteDataSource.fetchNasaImages(keyword, page).collection
        Log.d("APP_TAG", "SearchRepository - getData: $response  ")
        return response.items.map {
            Log.d("APP_TAG", "SearchRepository - getData:  data is $it")
            domainPhotoMapper.mapDataToDomain(it)
        }


    }


}