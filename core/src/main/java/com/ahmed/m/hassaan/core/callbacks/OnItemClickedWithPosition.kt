package com.ahmed.m.hassaan.core.callbacks

import android.view.View

interface OnItemClickedWithView<T> {
    fun onItemClicked( item: T, v:View)
}