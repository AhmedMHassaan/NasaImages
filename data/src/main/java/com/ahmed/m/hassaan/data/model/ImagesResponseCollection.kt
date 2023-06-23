package com.ahmed.m.hassaan.data.model

import com.google.gson.annotations.SerializedName

data class ImagesResponseCollection(
    val version: String,
    val href: String,
    val items: List<Items>,

    @SerializedName("metadata")
    val responseMetadata: ResponseMetadata
)
