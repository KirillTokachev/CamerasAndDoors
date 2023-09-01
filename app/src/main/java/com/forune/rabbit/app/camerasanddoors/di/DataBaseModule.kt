package com.forune.rabbit.app.camerasanddoors.di

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.data.database.model.DoorDbModel
import dagger.Module
import dagger.Provides
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration
import javax.inject.Singleton

@Singleton
@Module
interface DataBaseModule {

    @Singleton
    @Provides
    fun provideRealm(): Realm {
        val config = RealmConfiguration.Builder(
            schema = setOf(
                CameraDbModel::class,
                DoorDbModel::class
            )
        )
            .compactOnLaunch()
            .build()
        return Realm.open(config)
    }
}