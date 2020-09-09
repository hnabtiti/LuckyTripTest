package com.luckytrip.luckytrip.api


import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.luckytrip.luckytrip.BuildConfig
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Converter
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


const val CONTENT_TYPE = "application/json"

val apiClientModule = module {
    factory { createOkHttpClientInstance() }
    factory { createJsonConverter(get()) }
    factory { createRetrofitInstance(get(), get()) }

}

fun createRetrofitInstance(okHttpClient: OkHttpClient, converter: Converter.Factory): Retrofit {
    return Retrofit.Builder()
        .baseUrl(BuildConfig.SERVER_URL)
        .client(okHttpClient)
        .addConverterFactory(converter).build()
}


fun createJsonConverter(json:Json): Converter.Factory {
    return json.asConverterFactory(CONTENT_TYPE.toMediaTypeOrNull()!!)
}

fun createOkHttpClientInstance(): OkHttpClient {
    return OkHttpClient()
        .newBuilder()
        .readTimeout(1, TimeUnit.MINUTES)
        .connectTimeout(1, TimeUnit.MINUTES)
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .build()
}
