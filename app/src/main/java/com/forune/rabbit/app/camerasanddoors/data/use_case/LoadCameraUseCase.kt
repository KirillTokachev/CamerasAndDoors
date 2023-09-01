package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import com.forune.rabbit.app.camerasanddoors.domain.repository.CameraRepository
import kotlinx.coroutines.flow.Flow

class LoadCameraUseCase(
    private val repository: CameraRepository
) {

    suspend fun loadCamera(): Flow<List<Camera>> {
        return repository.loadCamera()
    }
}