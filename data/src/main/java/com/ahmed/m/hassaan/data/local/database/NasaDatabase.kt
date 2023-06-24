package com.ahmed.m.hassaan.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed.m.hassaan.data.model.NasaItemLocal


@Database(version = 2, exportSchema = false, entities = [NasaItemLocal::class])
abstract class NasaDatabase: RoomDatabase() {

    abstract fun nasaDao():NasaDao
}