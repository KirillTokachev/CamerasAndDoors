package com.forune.rabbit.app.camerasanddoors.data.network

import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.kotlinx.serializer.KotlinxSerializer
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.json.Json
import javax.inject.Inject


class DoorAndCameraHttpClient @Inject constructor() {

    fun getHttpClient() = HttpClient(Android) {
        install(ContentNegotiation) {
            json(Json{
                prettyPrint = true
                isLenient = true
                ignoreUnknownKeys = true
            }).serializer()
        }
        install(Logging) {
            level = LogLevel.ALL
        }
    }
}

