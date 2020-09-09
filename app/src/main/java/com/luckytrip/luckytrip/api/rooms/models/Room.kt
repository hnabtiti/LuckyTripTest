package com.luckytrip.luckytrip.api.rooms.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room (

    @SerialName("room_id") val roomId : Int,
    @SerialName("name") val name : String,
    @SerialName("room_description") val roomDescription : String,
    @SerialName("number_of_rooms_left") val numberOfRoomsLeft : Int,
    @SerialName("max_occupancy") val maxOccupancy : Int,
    @SerialName("price") val price : Price,
    @SerialName("bed_configurations") val bedConfigurations : List<BedConfigurations>,
    @SerialName("photos") val photos : List<String>
)