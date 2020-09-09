package com.luckytrip.luckytrip.json

import kotlinx.serialization.*
import kotlinx.serialization.json.Json

/**
 * this class responsible for json parsing
 */
class Parser(val json: Json) {

    inline fun <reified T : Any> fromJson(string: String, deserializer: DeserializationStrategy<T>): T {
        return json.decodeFromString(deserializer, string)
    }

    inline fun <reified T : Any> toJson(value: T): String {
        return json.encodeToString(value)
    }

    inline fun <reified T : Any> fromJson(string: String?): T? {
        if (string == null) return null
        return json.decodeFromString<T>(string)
    }
}



