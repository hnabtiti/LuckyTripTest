package com.luckytrip.luckytrip.extenstions

inline fun <reified T : Any> String.toDataClass(): T? {
    return parser.fromJson<T>(this)
}