package com.luckytrip.luckytrip.logger

import org.koin.dsl.module

val loggerModule = module {
    single { Logger() }
}