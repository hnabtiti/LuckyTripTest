package com.luckytrip.luckytrip.extenstions

import android.content.Context
import android.text.Spannable
import android.text.SpannableStringBuilder
import androidx.core.text.bold
import androidx.core.text.italic
import com.luckytrip.luckytrip.R
import com.luckytrip.luckytrip.api.rooms.models.Room

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