package com.luckytrip.luckytrip.api.rooms

import org.koin.dsl.module
import retrofit2.Retrofit

val roomsRepository = module {
    factory { createRoomsApiService(get()) }
    factory { createRoomsApiRepository(get()) }
}

fun createRoomsApiRepository(service: RoomsService): RoomsRepository =
    RoomsRepository(service)

fun createRoomsApiService(retrofit: Retrofit): RoomsService =
    retrofit.create(RoomsService::class.java)