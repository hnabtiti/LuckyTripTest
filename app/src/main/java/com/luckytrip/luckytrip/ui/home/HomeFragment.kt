package com.luckytrip.luckytrip.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.extenstions.toJson
import com.luckytrip.luckytrip.extenstions.tryNavigate
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

const val ROOM_TAG_KEY = "room"

class HomeFragment : Fragment() {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.apply {
            rooms.observe(viewLifecycleOwner, { rooms ->
                roomsRecyclerView.apply {
                    layoutManager = GridLayoutManager(activity, getNumberOfColumns(true))
                    rooms?.let {
                        val roomsAdapter = RoomsAdapter(rooms, true)
                        roomsAdapter.onRoomClicked = { room ->
                            val bundle = bundleOf(ROOM_TAG_KEY to room.toJson())
                            findNavController().tryNavigate(R.id.action_nav_home_to_nav_gallery, bundle)
                        }
                        adapter = roomsAdapter
                    }
                }
            })
        }
    }

    private fun getNumberOfColumns(isList: Boolean): Int {
        return if (isList) 1 else 3
    }
}




