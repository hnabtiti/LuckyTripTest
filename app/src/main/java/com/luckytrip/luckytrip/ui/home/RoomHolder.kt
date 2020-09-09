package com.luckytrip.luckytrip.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luckytrip.luckytrip.api.rooms.models.Room
import com.luckytrip.luckytrip.extenstions.setImageFromUrl
import com.luckytrip.luckytrip.extenstions.showWithCurrency
import kotlinx.android.synthetic.main.room_grid_item.view.*

class RoomHolder(inflater: LayoutInflater, parent: ViewGroup, designRes: Int) :
    RecyclerView.ViewHolder(inflater.inflate(designRes, parent, false)) {
    fun bind(room: Room, onClick: ((Room) -> Unit)?) {
        itemView.apply {
            room.apply {
                nameTextView.text = name
                descTextView.text = roomDescription
                priceTextView.text = price.showWithCurrency()
                photos.firstOrNull()?.let {
                    image.setImageFromUrl(it)
                }
            }
        }
        itemView.setOnClickListener {
            onClick?.invoke(room)
        }
    }
}