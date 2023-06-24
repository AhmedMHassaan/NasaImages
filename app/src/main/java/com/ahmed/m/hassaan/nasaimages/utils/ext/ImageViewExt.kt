package com.ahmed.m.hassaan.nasaimages.utils.ext

import android.widget.ImageView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide


object ImageViewExt {


    fun ImageView.loadImage(url: String?) {

        val progress = CircularProgressDrawable(this.context)
            .also {
                it.strokeWidth = 5f
                it.centerRadius = 30f

                it.start()
            }

        Glide
            .with(this)
            .load(url)
            .placeholder(progress)
            .into(this)

    }
}