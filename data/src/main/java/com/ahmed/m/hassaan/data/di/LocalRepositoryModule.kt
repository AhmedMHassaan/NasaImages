package com.ahmed.m.hassaan.data.di

import android.content.Context
import androidx.room.Room
import com.ahmed.m.hassaan.data.local.database.NasaDatabase
import com.ahmed.m.hassaan.data.local.datasource.LocalDataSource
import com.ahmed.m.hassaan.data.local.datasource.LocalDataSourceImpl
import com.ahmed.m.hassaan.data.mapper.LocalNasaItemMapper
import com.ahmed.m.hassaan.data.repository.LocalRepositoryImpl
import com.ahmed.m.hassaan.domain.repository.LocalRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class LocalRepositoryModule {

    @Provides
    fun provideLocalRepository(
        localDataSource: LocalDataSource,
        nasaDomainMapper: LocalNasaItemMapper
    ): LocalRepository = LocalRepositoryImpl(localDataSource, nasaDomainMapper)

    @Provides
    fun provideNasaItemMapper(): LocalNasaItemMapper = LocalNasaItemMapper()

    @Provides
    fun provideLocalDataSource(
        mapper: LocalNasaItemMapper,
        database: NasaDatabase
    ): LocalDataSource =
        LocalDataSourceImpl(mapper, database)


    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext context: Context): NasaDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            NasaDatabase::class.java,
            "nasa_items.db"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Singleton
    @Provides
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }


}