package com.ahmed.m.hassaan.nasaimages.utils.ext

import android.view.View
import com.google.android.material.snackbar.Snackbar

object ViewExt {

    fun View.createSnackbar(text: String) {
        Snackbar.make(this, text, Snackbar.LENGTH_SHORT).show()
    }
}