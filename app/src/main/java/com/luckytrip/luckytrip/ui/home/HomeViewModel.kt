package com.luckytrip.luckytrip.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.luckytrip.luckytrip.api.rooms.RoomsRepository
import com.luckytrip.luckytrip.api.rooms.models.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val homeViewModelModule = module {
    viewModel {
        HomeViewModel(get())
    }
}

class HomeViewModel(repo: RoomsRepository) : ViewModel() {
    val rooms: MutableLiveData<List<Room>?> by lazy {
        MutableLiveData<List<Room>?>()
    }

    init {
        CoroutineScope(Dispatchers.IO).launch {
            val roomsFromServer = repo.getRooms("en")
            rooms.postValue(roomsFromServer?.rooms)
        }
    }

}