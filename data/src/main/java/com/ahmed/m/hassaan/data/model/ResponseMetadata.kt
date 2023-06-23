package com.ahmed.m.hassaan.data.model

import com.google.gson.annotations.SerializedName

data class ResponseMetadata(
    @SerializedName("total_hits") val allItemsSizeInServer: Int
)
