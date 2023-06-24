package com.ahmed.m.hassaan.domain.repository

import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import kotlinx.coroutines.flow.Flow

interface LocalRepository {

    fun getData(): List<DomainNasaImage>

    fun saveLocalItems(nasaItemData: List<DomainNasaImage>)

}
