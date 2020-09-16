package com.luckytrip.luckytrip.extenstions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.luckytrip.luckytrip.R


fun ImageView.setImageFromUrl(url: String) {
    url.let {
        Glide.with(this.context)
            .load(it)
            .centerCrop()
            .placeholder(R.drawable.room_rent_default)
            .error(R.drawable.room_rent_default)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(this)
    }
}