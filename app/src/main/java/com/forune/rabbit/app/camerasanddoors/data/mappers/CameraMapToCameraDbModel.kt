package com.forune.rabbit.app.camerasanddoors.data.mappers

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.domain.model.Camera

class CameraMapToCameraDbModel : (Camera) -> CameraDbModel {

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