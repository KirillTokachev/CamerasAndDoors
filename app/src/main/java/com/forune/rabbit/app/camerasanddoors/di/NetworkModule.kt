package com.forune.rabbit.app.camerasanddoors.di

import com.forune.rabbit.app.camerasanddoors.data.network.DoorAndCameraHttpClient
import dagger.Module
import dagger.Provides
import io.ktor.client.HttpClient

@Module
interface NetworkModule {

    @Provides
    fun provideHttpClient(httpClient: DoorAndCameraHttpClient): HttpClient = httpClient.getHttpClient()
}