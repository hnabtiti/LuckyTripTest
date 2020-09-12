package com.luckytrip.luckytrip.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.api.rooms.models.Room
import com.luckytrip.luckytrip.extenstions.toDataClass

class GalleryFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_gallery, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val room = arguments?.getString("room")?.toDataClass<Room>()
        room?.apply {

        }
    }

}