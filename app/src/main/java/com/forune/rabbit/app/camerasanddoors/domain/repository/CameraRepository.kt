package com.forune.rabbit.app.camerasanddoors.domain.repository

import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import kotlinx.coroutines.flow.Flow

interface CameraRepository {

    suspend fun downloadCameras(): List<Camera>

    suspend fun loadCamera(): Flow<List<Camera>>
    
    suspend fun addCameraToFavorites(camera: Camera)
}