package com.ahmed.m.hassaan.data.remote.api

import com.ahmed.m.hassaan.data.model.ImagesResponse
import com.ahmed.m.hassaan.data.model.ImagesResponseCollection
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchApiEndPoints {

    @GET("search")
    suspend fun searchByKeyword(
        @Query("media_type") mediaType : String?="image",
        @Query("keywords")  keywords: String,
        @Query("page_size")  itemsPerPage: Int? = 20,
        @Query("page")  currentPage: Int
    ):Result<ImagesResponse>



}