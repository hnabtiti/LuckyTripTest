package com.luckytrip.luckytrip.rooms

import com.luckytrip.luckytrip.api.createJsonConverter
import com.luckytrip.luckytrip.api.createOkHttpClientInstance
import com.luckytrip.luckytrip.api.createRetrofitInstance
import com.luckytrip.luckytrip.api.json.createJsonInstance
import com.luckytrip.luckytrip.api.rooms.createRoomsApiRepository
import com.luckytrip.luckytrip.api.rooms.createRoomsApiService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class RoomRepositoryTest {
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Before
    fun setUp() {
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain() // reset main dispatcher to the original Main dispatcher
        mainThreadSurrogate.close()
    }


    @Test
    fun get_rooms_is_ok(): Unit = runBlocking {
        val okHttp = createOkHttpClientInstance()
        val jsonInstance = createJsonInstance()
        val jsonConverter = createJsonConverter(jsonInstance)
        val retrofit = createRetrofitInstance(okHttp, jsonConverter)
        val roomsService = createRoomsApiService(retrofit)
        val repository = createRoomsApiRepository(roomsService)
        val data = repository.getRooms("en")
        println("$data")
        assert(data != null)
        println("${data?.rooms}")
        assert(data?.rooms != null)
        println("${data?.rooms?.size}")
        assert(data?.rooms?.size == 6)
    }
}