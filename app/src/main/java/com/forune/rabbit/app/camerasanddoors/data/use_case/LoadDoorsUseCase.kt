package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository
import kotlinx.coroutines.flow.Flow

class LoadDoorsUseCase(
    private val repository: DoorRepository
) {

    suspend fun loadDoors(): Flow<List<Door>> {
        return repository.loadDoors()
    }
}