package com.ahmed.m.hassaan.nasaimages.utils.ext

import android.content.Intent
import android.os.Build
import java.io.Serializable
import java.util.Objects

object IntentExt {

    fun <T : Serializable?> Intent.getSerializableObject(
        key: String,
        clazz: Class<T>
    ): T {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            return extras?.getSerializable(key, clazz)!!
        } else {
            return extras?.getSerializable(key) as T
        }
    }
}