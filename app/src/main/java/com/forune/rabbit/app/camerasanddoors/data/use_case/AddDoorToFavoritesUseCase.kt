package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository
import javax.inject.Inject

class AddDoorToFavoritesUseCase @Inject constructor(
    private val repository: DoorRepository
) {

    suspend fun addDoorToFavorites(door: Door) {
        repository.renameDoor(door)
    }
}