package com.ahmed.m.hassaan.data.di

import com.ahmed.m.hassaan.data.remote.adapter.ApiCallAdapterFactory
import com.ahmed.m.hassaan.data.remote.api.SearchApiEndPoints
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {


    @Provides
    fun provideRetrofit(
        factory: ApiCallAdapterFactory
    ) =
        Retrofit
            .Builder()
            .baseUrl("https://images-api.nasa.gov/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(factory)
            .build()


    @Provides
    fun provideSearchApiService(retrofit: Retrofit) =
        retrofit.create(SearchApiEndPoints::class.java)


}