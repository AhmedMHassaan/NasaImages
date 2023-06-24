package com.ahmed.m.hassaan.data.local.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ahmed.m.hassaan.data.model.NasaItemLocal
import kotlinx.coroutines.flow.Flow

@Dao
interface NasaDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun cacheNasaImages(nasaImages: List<NasaItemLocal>)


    @Query("Select * from nasa_images")
    fun getCashedImages(): List<NasaItemLocal>
}