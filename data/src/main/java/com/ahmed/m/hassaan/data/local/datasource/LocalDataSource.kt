package com.ahmed.m.hassaan.data.local.datasource

import com.ahmed.m.hassaan.data.model.NasaItemLocal
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun getData(): List<NasaItemLocal>

    fun saveLocalItems(nasaItemData: List<NasaItemLocal>)


}
