package com.ahmed.m.hassaan.nasaimages.presentation.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ahmed.m.hassaan.core.adapter.BaseRecyclerAdapter
import com.ahmed.m.hassaan.core.callbacks.OnItemClickedWithView
import com.ahmed.m.hassaan.domain.model.DomainNasaImage
import com.ahmed.m.hassaan.nasaimages.R
import com.ahmed.m.hassaan.nasaimages.databinding.ItemNasaImageBinding

class NasaAdapter :
    BaseRecyclerAdapter<DomainNasaImage, ItemNasaImageBinding, NasaImageViewHolder>() {


    var listener: OnItemClickedWithView<DomainNasaImage>?=null
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaImageViewHolder {
        return NasaImageViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_nasa_image, parent, false),
            listener
        )
    }
}