package com.forune.rabbit.app.camerasanddoors.data.repositoryImpls

import com.forune.rabbit.app.camerasanddoors.data.database.model.CameraDbModel
import com.forune.rabbit.app.camerasanddoors.data.database.model.DoorDbModel
import com.forune.rabbit.app.camerasanddoors.data.mappers.DoorDbModelMapToDoor
import com.forune.rabbit.app.camerasanddoors.data.mappers.DoorMapToDoorDbModel
import com.forune.rabbit.app.camerasanddoors.data.network.HttpRoutes
import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import com.forune.rabbit.app.camerasanddoors.domain.repository.DoorRepository
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.realm.kotlin.Realm
import io.realm.kotlin.ext.query
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DoorsRepositoryImpl(
    val realm: Realm,
    val client: HttpClient,
    val doorMapToDoorDbModel: DoorMapToDoorDbModel,
    val doorDbDbModelMapToDoor: DoorDbModelMapToDoor
) : DoorRepository {

    override suspend fun downloadDoors(): List<Door> {
        return client.get {
            url(HttpRoutes.GET_DOORS)
        }.body()
    }

    override fun loadDoors(): Flow<List<Door>> {
        return realm.query<DoorDbModel>().asFlow().map { resultsChange -> resultsChange.list.map(doorDbDbModelMapToDoor) }
    }

    override suspend fun renameDoor(door: Door) {
        realm.write {
            val dbModel = doorMapToDoorDbModel(door)
            val queriedCamera = query<CameraDbModel>(query = "id == $0", dbModel.id).first().find()
            queriedCamera?.name = dbModel.name
        }
    }

    override suspend fun addDoorToFavorites(door: Door) {
        realm.write {
            val dbModel = doorMapToDoorDbModel(door)
            val queriedCamera = query<CameraDbModel>(query = "id == $0", dbModel.id).first().find()
            queriedCamera?.favorites = dbModel.favorites
        }
    }
}