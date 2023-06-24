package com.ahmed.m.hassaan.data.repository

import android.util.Log
import com.ahmed.m.hassaan.data.local.datasource.LocalDataSource
import com.ahmed.m.hassaan.data.mapper.LocalNasaItemMapper
import com.ahmed.m.hassaan.data.mapper.RemoteNasaItemMapper
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.domain.repository.LocalRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class LocalRepositoryImpl @Inject constructor(
    private val localDataSource: LocalDataSource,
    private val nasaItemMapper: LocalNasaItemMapper
) : LocalRepository {
    override fun getData(): List<DomainNasaImage> {
        val data = localDataSource.getData()
//        return data
        return data.map {
            nasaItemMapper.mapDataToDomain(it)
        }
    }

    override fun saveLocalItems(nasaItemData: List<DomainNasaImage>) {
        val data = nasaItemData.map {
            nasaItemMapper.mapDomainToData(it)
        }
        Log.d(
            "APP_TAG",
            "LocalRepositoryImpl - saveLocalItems:  data will be saved $nasaItemData"
        )
        localDataSource.saveLocalItems(data)
    }

}