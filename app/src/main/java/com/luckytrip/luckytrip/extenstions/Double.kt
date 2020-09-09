package com.luckytrip.luckytrip.extenstions

fun Double.show3Digits(): String {
    return String.format("%.3f", this)
}