package com.forune.rabbit.app.camerasanddoors.data.mappers

import com.forune.rabbit.app.camerasanddoors.data.database.model.DoorDbModel
import com.forune.rabbit.app.camerasanddoors.domain.model.Door

class DoorDbModelMapToDoor : (DoorDbModel) -> Door {

    override fun invoke(value: DoorDbModel): Door =
        with(value) {
            Door(
                id = id,
                name = name,
                room = room,
                favorites = favorites
            )
        }
}