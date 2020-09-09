package com.luckytrip.luckytrip.api.rooms


import com.luckytrip.luckytrip.api.rooms.models.RoomsWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface RoomsService {
    @GET("test/rooms")
    suspend fun getRooms(@Query("language_code") languageCode: String): RoomsWrapper
}
