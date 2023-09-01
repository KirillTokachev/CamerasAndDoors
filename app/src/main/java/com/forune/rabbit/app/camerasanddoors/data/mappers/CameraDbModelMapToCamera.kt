package com.forune.rabbit.app.camerasanddoors.data.mappers

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.domain.model.Camera

class CameraDbModelMapToCamera : (CameraDbModel) -> Camera {
    override fun invoke(value: CameraDbModel): Camera =
        with(value) {
            Camera(
                id = id,
                name = name,
                snapshot = snapshot,
                room = room,
                favorites = favorites,
                rec = rec
            )
        }
}