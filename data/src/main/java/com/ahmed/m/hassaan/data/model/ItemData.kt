package com.ahmed.m.hassaan.data.model

data class ItemData(
    val center:String,
    val title:String,
    val nasa_id:String,
    val media_type:String,
    val keywords:List<String>,
    val date_created:String,
    val description_508:String?,
    val secondary_creator:String?,
    val description:String
)
