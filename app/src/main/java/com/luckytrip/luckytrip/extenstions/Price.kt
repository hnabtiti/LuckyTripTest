package com.luckytrip.luckytrip.extenstions

import com.luckytrip.luckytrip.api.rooms.models.Price

fun Price.showWithCurrency(): String {
    return "$currency ${priceValue.show3Digits()}"
}