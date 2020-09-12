package com.luckytrip.luckytrip.ui.gallery

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.api.rooms.models.Room
import com.luckytrip.luckytrip.extenstions.getFullDesc
import com.luckytrip.luckytrip.extenstions.showWithCurrency
import com.luckytrip.luckytrip.json.Parser
import com.luckytrip.luckytrip.ui.home.ROOM_TAG_KEY
import com.luckytrip.luckytrip.ui.home.SliderAdapter
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType
import com.smarteist.autoimageslider.SliderAnimations
import com.smarteist.autoimageslider.SliderView
import kotlinx.android.synthetic.main.fragment_room_info.*
import org.koin.android.ext.android.inject

class RoomInfoFragment : Fragment() {

    private val parser by inject<Parser>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_room_info, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val room = parser.fromJson<Room>(arguments?.getString(ROOM_TAG_KEY))
        room?.apply {
            nameTextView.text = name
            descTextView.text = getFullDesc(requireContext())
            priceTextView.text = price.showWithCurrency()
            maxOccupancyTextView.text = "$maxOccupancy"
            imageSliderView.apply {
                setSliderAdapter(SliderAdapter(photos), true)
                setIndicatorAnimation(IndicatorAnimationType.WORM)
                setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION)
                autoCycleDirection = SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH
                indicatorSelectedColor = Color.WHITE
                indicatorUnselectedColor = Color.GRAY
                scrollTimeInSec = 3
                isAutoCycle = true

                startAutoCycle()
            }
        }
    }

}