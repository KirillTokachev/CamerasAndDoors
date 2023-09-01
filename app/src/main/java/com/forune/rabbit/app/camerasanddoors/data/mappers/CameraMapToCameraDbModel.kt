package com.forune.rabbit.app.camerasanddoors.data.mappers

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import javax.inject.Inject

class CameraMapToCameraDbModel @Inject constructor() : (Camera) -> CameraDbModel {

    override fun invoke(value: Camera): CameraDbModel =
        with(value) {
            CameraDbModel(
                id = id,
                name = name,
                snapshot = snapshot,
                room = room,
                favorites = favorites,
                rec = rec
            )
        }
}