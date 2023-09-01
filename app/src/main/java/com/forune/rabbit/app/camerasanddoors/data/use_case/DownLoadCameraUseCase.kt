package com.forune.rabbit.app.camerasanddoors.data.use_case

import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import com.forune.rabbit.app.camerasanddoors.domain.repository.CameraRepository
import javax.inject.Inject

class DownLoadCameraUseCase @Inject constructor(
    private val repository: CameraRepository
) {

    suspend fun downLoadCameras(): List<Camera> {
        return repository.downloadCameras()
    }
}