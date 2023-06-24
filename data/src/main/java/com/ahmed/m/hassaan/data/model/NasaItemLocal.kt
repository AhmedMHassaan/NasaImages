package com.ahmed.m.hassaan.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.ahmed.m.hassaan.data.local.database.KeywordsTypeConverter

@Entity("nasa_images")
@TypeConverters(KeywordsTypeConverter::class)
data class NasaItemLocal(
    @PrimaryKey
    val nasa_id: String,
    val title: String,
    val center: String,
    val keywords: List<String>,
    val date_created: String,
    val description_508: String?,
    val secondary_creator: String?,
    val description: String,
    val imageLink: String
)