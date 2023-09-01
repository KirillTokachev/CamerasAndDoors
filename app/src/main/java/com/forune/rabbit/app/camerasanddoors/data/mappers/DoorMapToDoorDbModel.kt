package com.forune.rabbit.app.camerasanddoors.data.mappers

import com.forune.rabbit.app.camerasanddoors.data.database.model.DoorDbModel
import com.forune.rabbit.app.camerasanddoors.domain.model.Door

class DoorMapToDoorDbModel : (Door) -> DoorDbModel {

    override fun invoke(value: Door): DoorDbModel =
        with(value) {
            DoorDbModel(
                id = id,
                name = name,
                room = room,
                favorites = favorites
            )
        }
}