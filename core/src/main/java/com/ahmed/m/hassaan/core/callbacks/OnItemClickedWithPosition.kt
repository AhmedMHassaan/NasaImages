package com.ahmed.m.hassaan.core.callbacks

interface OnItemClickedWithPosition<T> {
    fun onItemClicked(position: Int, item: T)
}