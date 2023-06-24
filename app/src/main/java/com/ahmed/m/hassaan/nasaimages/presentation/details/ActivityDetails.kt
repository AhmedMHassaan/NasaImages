package com.ahmed.m.hassaan.nasaimages.presentation.details

import android.app.Activity
import android.os.Bundle
import android.view.View
import com.ahmed.m.hassaan.core.activity.BaseActivityBinding
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.R
import com.ahmed.m.hassaan.nasaimages.databinding.ActivityDetailsBinding
import com.ahmed.m.hassaan.nasaimages.utils.ext.ImageViewExt.loadImage
import com.ahmed.m.hassaan.nasaimages.utils.ext.IntentExt.getSerializableObject
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.google.android.material.transition.platform.MaterialContainerTransformSharedElementCallback

class ActivityDetails : BaseActivityBinding<ActivityDetailsBinding>() {

    private lateinit var nasaItem:DomainNasaImage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        with(this as Activity) {
            findViewById<View>(android.R.id.content).transitionName = "trans"
            setEnterSharedElementCallback(MaterialContainerTransformSharedElementCallback())

            val transform = MaterialContainerTransform()
            transform.addTarget(android.R.id.content)
            transform.duration = 450

            window.sharedElementEnterTransition = transform
            window.sharedElementReturnTransition = transform

        }


        nasaItem = intent.getSerializableObject("item",DomainNasaImage::class.java)
        binding.detailPhoto.loadImage(nasaItem.imageLink)
        binding.nasaImage = nasaItem




    }

    override fun getLayoutId() = R.layout.activity_details
}