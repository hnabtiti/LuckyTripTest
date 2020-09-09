package com.luckytrip.luckytrip.api.json


import com.luckytrip.luckytrip.json.Parser
import kotlinx.serialization.json.Json
import org.koin.dsl.module

val parsingModules = module {
    single { createJsonInstance() }
    single { Parser(get()) }
}

fun createJsonInstance(): Json {
    return Json {
        isLenient = true
        ignoreUnknownKeys = true
    }
}