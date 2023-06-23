package com.ahmed.m.hassaan.data.di

import com.ahmed.m.hassaan.data.mapper.NasaItemMapper
import com.ahmed.m.hassaan.data.remote.api.SearchApiEndPoints
import com.ahmed.m.hassaan.data.remote.datasources.RemoteDataSource
import com.ahmed.m.hassaan.data.repository.SearchRepository
import com.ahmed.m.hassaan.domain.repository.RemoteImagesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {


    @Provides
    fun provideRepository(
        remoteDataSource: RemoteDataSource,
        domainPhotoMapper: NasaItemMapper
    ): RemoteImagesRepository = SearchRepository(remoteDataSource, domainPhotoMapper)

    @Provides
    fun provideNasaItemMapper():NasaItemMapper = NasaItemMapper()

    @Provides
    fun provideRemoteDataSource(remoteSearchApi:SearchApiEndPoints):RemoteDataSource = RemoteDataSource(remoteSearchApi)
}