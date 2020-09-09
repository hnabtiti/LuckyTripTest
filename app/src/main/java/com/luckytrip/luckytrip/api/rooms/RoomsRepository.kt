package com.luckytrip.luckytrip.api.rooms

import com.luckytrip.luckytrip.api.rooms.models.RoomsWrapper
import com.luckytrip.luckytrip.extenstions.logExecution

class RoomsRepository(private val service: RoomsService) {
    suspend fun getRooms(languageCode: String): RoomsWrapper? {
        return try {
            service.getRooms(languageCode)
        } catch (e: Exception) {
            logExecution(e)
            null
        }
    }
}