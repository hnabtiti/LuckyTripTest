package com.luckytrip.luckytrip.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.api.rooms.models.Room


class RoomsAdapter(val rooms: List<Room>, private val isList: Boolean, onClick: ((Room) -> Unit)? = null) :
    RecyclerView.Adapter<RoomHolder>() {
    var onRoomClicked: ((Room) -> Unit)? = onClick


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomHolder {
        val inflater = LayoutInflater.from(parent.context)
        val designRes = if (isList) R.layout.room_list_item else R.layout.room_grid_item
        return RoomHolder(inflater, parent, designRes)
    }

    override fun onBindViewHolder(holder: RoomHolder, position: Int) {
        holder.bind(rooms[position], onRoomClicked)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = rooms.size
}



