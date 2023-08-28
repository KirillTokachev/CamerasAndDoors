package com.forune.rabbit.app.camerasanddoors.domain.repository

import com.forune.rabbit.app.camerasanddoors.domain.model.Camera

interface CameraRepository {

    fun downloadCameras(): List<Camera>

    fun loadCamera(): List<Camera>

    fun rename(newName: String)
}