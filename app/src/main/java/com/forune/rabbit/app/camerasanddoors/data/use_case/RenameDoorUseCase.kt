package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository

class RenameDoorUseCase(
    private val repository: DoorRepository
) {

    suspend fun renameDoor(door: Door) {
        repository.renameDoor(door)
    }
}