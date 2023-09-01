package com.forune.rabbit.app.camerasanddoors.di

import com.forune.rabbit.app.camerasanddoors.data.repositoryImpls.DoorsRepositoryImpl
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository
import dagger.Binds
import dagger.Module

@Module
interface DoorModule {

    @Binds
    fun bindDoorsRepository(impl: DoorsRepositoryImpl): DoorRepository
}