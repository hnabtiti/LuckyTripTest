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
import com.luckytrip.luckytrip.api.rooms.models.Room
import com.luckytrip.luckytrip.extenstions.tryNavigate
import com.luckytrip.luckytrip.json.Parser
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel

const val ROOM_TAG_KEY = "room"

class HomeFragment : Fragment() {

    private val homeViewModel by viewModel<HomeViewModel>()
    private val parser by inject<Parser>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


        homeViewModel.apply {

            isViewingTypeList.apply {
                viewingTypeImageButton.setOnClickListener {
                    val resId = if (value == true) R.drawable.grid else R.drawable.list
                    viewingTypeImageButton.setImageResource(resId)
                    value = !(value ?: false)
                }
            }

            isViewingTypeList.observe(viewLifecycleOwner, { isViewingTypeListValue ->
                if (isViewingTypeListValue == null) return@observe
                val rooms = rooms.value ?: return@observe
                populateRoomsRecyclerView(rooms, isViewingTypeListValue)
            })

            rooms.observe(viewLifecycleOwner, { rooms ->
                if (rooms == null) return@observe
                val isViewingTypeListValue = isViewingTypeList.value ?: return@observe
                populateRoomsRecyclerView(rooms, isViewingTypeListValue)
            })
        }
    }

    private fun populateRoomsRecyclerView(rooms: List<Room>, isViewingTypeList: Boolean) {
        roomsRecyclerView.apply {
            layoutManager = GridLayoutManager(activity, getNumberOfColumns(isViewingTypeList))

            val roomsAdapter = RoomsAdapter(rooms, isViewingTypeList)

            roomsAdapter.onRoomClicked = { room ->
                val bundle = bundleOf(ROOM_TAG_KEY to parser.toJson(room))
                findNavController().tryNavigate(R.id.action_nav_home_to_nav_gallery, bundle)
            }

            adapter = roomsAdapter

        }

    }

    private fun getNumberOfColumns(isList: Boolean): Int {
        return if (isList) 1 else 2
    }
}




