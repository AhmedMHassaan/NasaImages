package com.ahmed.m.hassaan.domain.model

data class DomainNasaImage(
    val title:String,
    val nasa_id:String,
    val center:String,
    val keywords:List<String>,
    val date_created:String,
    val description_508:String?,
    val secondary_creator:String?,
    val description:String,
    val imageLink:String
)