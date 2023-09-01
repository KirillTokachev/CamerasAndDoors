package com.forune.rabbit.app.camerasanddoors.data.database

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.data.database.model.DoorDbModel
import io.realm.kotlin.Realm
import io.realm.kotlin.RealmConfiguration

open class AppDataBase {

    private val config = RealmConfiguration.create(schema = setOf(CameraDbModel::class, DoorDbModel::class))
    open val realm: Realm = Realm.open(config)
}