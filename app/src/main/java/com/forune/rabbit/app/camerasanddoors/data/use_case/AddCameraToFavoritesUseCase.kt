package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import com.forune.rabbit.app.camerasanddoors.domain.repository.CameraRepository

class AddCameraToFavoritesUseCase(
    private val repository: CameraRepository
) {

    suspend fun addCameraToFavorites(camera: Camera) {
        repository.addCameraToFavorites(camera)
    }
}