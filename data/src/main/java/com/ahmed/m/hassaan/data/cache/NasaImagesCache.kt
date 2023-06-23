package com.ahmed.m.hassaan.data.cache

import com.ahmed.m.hassaan.data.model.Items

interface NasaImagesCache {

    suspend fun saveImages(imagesResponse: List<Items>)
}