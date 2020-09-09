package com.luckytrip.luckytrip.api.rooms.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class BedConfigurations (
	@SerialName("count") val count : Int,
	@SerialName("name") val name : String
)