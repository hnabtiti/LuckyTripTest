package com.luckytrip.luckytrip.api.rooms.models

import android.content.Context
import android.graphics.Typeface
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.style.StyleSpan
import androidx.core.text.bold
import androidx.core.text.italic
import com.luckytrip.luckytrip.R
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Room(
    @SerialName("room_id") val roomId: Int,
    @SerialName("name") val name: String,
    @SerialName("room_description") val roomDescription: String,
    @SerialName("number_of_rooms_left") val numberOfRoomsLeft: Int,
    @SerialName("max_occupancy") val maxOccupancy: Int,
    @SerialName("price") val price: Price,
    @SerialName("bed_configurations") val bedConfigurations: List<BedConfigurations>,
    @SerialName("photos") val photos: List<String>
)

fun Room.getFullDesc(context: Context): Spannable? {
    val spannable = SpannableStringBuilder()
    if (roomDescription.isNotBlank()) {
        spannable.bold { appendLine(roomDescription) }
    }
    bedConfigurations.forEach {
        val quantityText = context.getString(R.string.quantity_desc, it.count, it.name)
        spannable.italic {
            append(quantityText)
        }

    }
    return spannable

}