package com.ahmed.m.hassaan.data.local.datasource

import android.util.Log
import com.ahmed.m.hassaan.data.local.database.NasaDao
import com.ahmed.m.hassaan.data.local.database.NasaDatabase
import com.ahmed.m.hassaan.data.mapper.LocalNasaItemMapper
import com.ahmed.m.hassaan.data.model.NasaItemLocal
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val mapper: LocalNasaItemMapper,
    private val database: NasaDatabase
) : LocalDataSource {
    override fun getData(): List<NasaItemLocal> {
        return database.nasaDao().getCashedImages()
    }

    override fun saveLocalItems(nasaItemData: List<NasaItemLocal>) {
//        return flow {
        Log.d(
            "APP_TAG",
            "LocalDataSourceImpl - saveLocalItems:  data will be saved in $nasaItemData"
        )
//            emit(
        database.nasaDao().cacheNasaImages(nasaItemData)
//            )
//    }

    }
}