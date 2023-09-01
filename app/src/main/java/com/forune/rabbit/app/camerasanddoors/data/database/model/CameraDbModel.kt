package com.forune.rabbit.app.camerasanddoors.data.database.model

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import kotlinx.serialization.Serializable


@Serializable
class CameraDbModel(
    @PrimaryKey
    var id: Int,
    var name: String,
    var snapshot: String,
    var room: String?,
    var favorites: Boolean,
    var rec: Boolean
) : RealmObject {
    constructor(): this(0,"","","",false,false)
}