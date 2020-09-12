package com.luckytrip.luckytrip.extenstions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners


fun ImageView.setImageFromUrl(url: String) {
    url.let {
        Glide.with(this.context)
            .load(it)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
//            .transform(CenterCrop(), RoundedCorners(100))
            .into(this)
    }
}