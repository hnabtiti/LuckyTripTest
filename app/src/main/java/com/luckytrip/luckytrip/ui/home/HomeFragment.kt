package com.luckytrip.luckytrip.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.luckytrip.luckytrip.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        homeViewModel.apply {
            rooms.observe(viewLifecycleOwner, { rooms ->
                roomsRecyclerView.apply {
                    layoutManager = GridLayoutManager(activity, getNumberOfColumns(true))
                    rooms?.let {
                        adapter = RoomsAdapter(rooms, true)

                    }
                }
            })
        }
    }

    private fun getNumberOfColumns(isList: Boolean): Int {
        return if (isList) 1 else 3
    }
}