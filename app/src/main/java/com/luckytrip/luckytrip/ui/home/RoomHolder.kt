package com.luckytrip.luckytrip.ui.home

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.luckytrip.luckytrip.api.rooms.models.Room
import com.luckytrip.luckytrip.api.rooms.models.getFullDesc
import com.luckytrip.luckytrip.extenstions.showWithCurrency
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.room_list_item.view.*

class RoomHolder(inflater: LayoutInflater, parent: ViewGroup, designRes: Int) :
    RecyclerView.ViewHolder(inflater.inflate(designRes, parent, false)) {
    fun bind(room: Room, onClick: ((Room) -> Unit)?) {
        itemView.apply {
            room.also { room ->
                nameTextView.text = room.name
                descTextView.text = room.getFullDesc(context)
                priceTextView.text = room.price.showWithCurrency()
                maxOccupancyTextView.text = "${room.maxOccupancy}"
                imageSliderView.apply {
                    setSliderAdapter(SliderAdapter(room.photos) {
                        onClick?.invoke(room)

                    }, true)
                    setIndicatorAnimation(IndicatorAnimationType.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
                    setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
                    autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH;
                    indicatorSelectedColor = Color.WHITE;
                    indicatorUnselectedColor = Color.GRAY;
                    scrollTimeInSec = 3
                    isAutoCycle = true

                    startAutoCycle()
                }
                imageSliderView.setOnIndicatorClickListener { onClick?.invoke(room) }
                imageSliderView.setOnClickListener { onClick?.invoke(room) }
                setOnClickListener { onClick?.invoke(room) }
            }
        }
        itemView.setOnClickListener {
            onClick?.invoke(room)
        }
    }
}