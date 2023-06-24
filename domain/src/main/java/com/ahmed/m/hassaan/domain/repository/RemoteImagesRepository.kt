package com.ahmed.m.hassaan.domain.repository

import com.ahmed.m.hassaan.domain.model.DomainNasaImage

interface RemoteImagesRepository {
   suspend fun getData(
        keyword: String, page: Int
    ): List<DomainNasaImage>



}