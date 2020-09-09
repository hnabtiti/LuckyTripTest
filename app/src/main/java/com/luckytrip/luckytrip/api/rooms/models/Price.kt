package com.luckytrip.luckytrip.api.rooms.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Price (
	@SerialName("currency") val currency : String,
	@SerialName("price_value") val priceValue : Double
)