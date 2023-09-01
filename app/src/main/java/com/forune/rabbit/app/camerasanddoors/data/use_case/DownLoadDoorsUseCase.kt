package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository

class DownLoadDoorsUseCase(
    private val repository: DoorRepository
) {

    suspend fun downLoadDoors(): List<Door> {
        return repository.downloadDoors()
    }
}