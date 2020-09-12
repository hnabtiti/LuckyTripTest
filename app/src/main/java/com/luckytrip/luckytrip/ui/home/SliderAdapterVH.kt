package com.luckytrip.luckytrip.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.extenstions.setImageFromUrl
import com.smarteist.autoimageslider.SliderViewAdapter
import kotlinx.android.synthetic.main.image_slider_layout_item.view.*

class SliderAdapterVH(inflater: LayoutInflater, parent: ViewGroup) :
    SliderViewAdapter.ViewHolder(inflater.inflate(R.layout.image_slider_layout_item, parent, false)) {
    private val imageView: ImageView = itemView.imageView
    fun bind(url: String, onClick: (() -> Unit)?) {
        itemView.setOnClickListener {
            onClick?.invoke()
        }
        imageView.setImageFromUrl(url)
        imageView.setOnClickListener {
            onClick?.invoke()
        }

    }
}