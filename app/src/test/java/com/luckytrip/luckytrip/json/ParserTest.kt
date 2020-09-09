package com.luckytrip.luckytrip.json

import com.luckytrip.luckytrip.api.json.createJsonInstance
import kotlinx.serialization.Serializable
import org.junit.Test

@Serializable
data class Project(val name: String, val language: String)

class ParserTest {
    @Test
    fun fromJson_test_parsing_is_ok() {
        val string = "{\"name\":\"kotlinx.serialization\",\"language\":\"Kotlin\"}"
        val parser = Parser(createJsonInstance())
        val dataClass = parser.fromJson<Project>(string)
        print(dataClass)
        assert(dataClass?.name == "kotlinx.serialization")
        assert(dataClass?.language == "Kotlin")
    }

    @Test
    fun toJson_test_parsing_is_ok() {
        val data = Project("kotlinx.serialization", "Kotlin")
        val parser = Parser(createJsonInstance())
        val string = parser.toJson(data)
        print(string)
        assert(string == "{\"name\":\"kotlinx.serialization\",\"language\":\"Kotlin\"}")
    }
}