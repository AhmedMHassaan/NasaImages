package com.ahmed.m.hassaan.nasaimages.utils.ext

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

object RecViewExt {

    fun RecyclerView.setupWithAdapter(adapter: RecyclerView.Adapter<*>) {
        this.adapter = adapter
        this.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, true)
    }

    fun RecyclerView.setupWithAdapter(
        adapter: RecyclerView.Adapter<*>,
        manager: RecyclerView.LayoutManager
    ) {
        this.adapter = adapter
        this.layoutManager = manager
    }

}