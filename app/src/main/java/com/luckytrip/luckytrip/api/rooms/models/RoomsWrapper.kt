package com.luckytrip.luckytrip.api.rooms.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RoomsWrapper (
	@SerialName("rooms") val rooms : List<Room>
)