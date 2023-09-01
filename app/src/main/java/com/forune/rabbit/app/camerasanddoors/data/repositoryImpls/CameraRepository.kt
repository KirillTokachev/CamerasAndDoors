package com.forune.rabbit.app.camerasanddoors.data.repositoryImpls

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.data.mappers.CameraDbModelMapToCamera
import com.forune.rabbit.app.camerasanddoors.data.mappers.CameraMapToCameraDbModel
import com.forune.rabbit.app.camerasanddoors.data.network.HttpRoutes
import com.forune.rabbit.app.camerasanddoors.domain.model.Camera
import com.forune.rabbit.app.camerasanddoors.domain.repository.CameraRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CamerasRepositoryImpl(
    val realm: Realm,
    val client: HttpClient,
    val cameraDbModelMapToCamera: CameraDbModelMapToCamera,
    val cameraMapToCameraDbModel: CameraMapToCameraDbModel
) : CameraRepository {

    override suspend fun downloadCameras(): List<Camera> {
        return client.get {
            url(HttpRoutes.GET_CAMERAS)
        }.body()
    }

    override suspend fun loadCamera(): Flow<List<Camera>> {
        return realm.query<CameraDbModel>().asFlow().map { resultsChange -> resultsChange.list.map(cameraDbModelMapToCamera) }
    }

    override suspend fun addCameraToFavorites(camera: Camera) {
        realm.write {
            val dbModel = cameraMapToCameraDbModel(camera)
            val queriedCamera = query<CameraDbModel>(query = "id == $0", dbModel.id).first().find()
            queriedCamera?.favorites = dbModel.favorites
        }
    }
}