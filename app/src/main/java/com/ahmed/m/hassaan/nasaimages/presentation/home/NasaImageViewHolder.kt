package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.view.View
import com.ahmed.m.hassaan.core.callbacks.OnItemClicked
import com.ahmed.m.hassaan.core.callbacks.OnItemClickedWithPosition
import com.ahmed.m.hassaan.core.viewholder.BaseViewHolder
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.databinding.ItemNasaImageBinding
import com.ahmed.m.hassaan.nasaimages.utils.ext.ImageViewExt.loadImage

class NasaImageViewHolder(itemView: View, var listener: OnItemClickedWithPosition<DomainNasaImage>?) :
    BaseViewHolder<DomainNasaImage, ItemNasaImageBinding>(
        itemView
    ) {
    override fun onBind(model: DomainNasaImage?) {
        binding.item = model
        binding.ivNasaImage.loadImage(model?.imageLink)
        binding.pos = adapterPosition
        binding.listener = listener
    }
}