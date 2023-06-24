package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.view.View
import com.ahmed.m.hassaan.core.callbacks.OnItemClickedWithView
import com.ahmed.m.hassaan.core.viewholder.BaseViewHolder
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.databinding.ItemNasaImageBinding
import com.ahmed.m.hassaan.nasaimages.utils.ext.ImageViewExt.loadImage

class NasaImageViewHolder(itemView: View, var listener: OnItemClickedWithView<DomainNasaImage>?) :
    BaseViewHolder<DomainNasaImage, ItemNasaImageBinding>(
        itemView
    ) {
    override fun onBind(model: DomainNasaImage?) {
        binding.item = model
        binding.ivNasaImage.loadImage(model?.imageLink)
        binding.listener = listener
    }
}