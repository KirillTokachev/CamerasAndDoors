package com.forune.rabbit.app.camerasanddoors.di

import com.forune.rabbit.app.camerasanddoors.data.repositoryImpls.CamerasRepositoryImpl
import com.forune.rabbit.app.camerasanddoors.domain.repository.CameraRepository
import dagger.Binds
import dagger.Module

@Module
interface CameraModule {

    @Binds
    fun bindCamerasRepository(impl: CamerasRepositoryImpl): CameraRepository
}