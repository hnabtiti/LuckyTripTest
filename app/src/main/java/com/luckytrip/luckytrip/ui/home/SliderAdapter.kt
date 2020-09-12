package com.luckytrip.luckytrip.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import com.smarteist.autoimageslider.SliderViewAdapter


class SliderAdapter(private val sliderItems: List<String>,val onClick: (() -> Unit)?) : SliderViewAdapter<SliderAdapterVH>() {

    override fun onCreateViewHolder(parent: ViewGroup): SliderAdapterVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        return SliderAdapterVH(layoutInflater, parent)
    }

    override fun onBindViewHolder(viewHolder: SliderAdapterVH, position: Int) {
        viewHolder.bind(sliderItems[position],onClick)
    }

    override fun getCount(): Int = sliderItems.size

}