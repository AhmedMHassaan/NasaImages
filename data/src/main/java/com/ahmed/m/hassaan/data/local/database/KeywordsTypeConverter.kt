package com.ahmed.m.hassaan.data.local.database

import android.R.attr.data
import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


class KeywordsTypeConverter {

    @TypeConverter
    fun restoreKeywordsFromString(keywords: String): List<String> {
        val gson = Gson()
        val listType: Type = object : TypeToken<List<String>>() {}.type
        return gson.fromJson(keywords, listType)
    }

    @TypeConverter
    fun convertKeywordsToString(list:List<String>): String {
        return Gson().toJson(list)
    }
}