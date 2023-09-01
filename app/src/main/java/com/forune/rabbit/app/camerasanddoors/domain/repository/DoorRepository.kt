package com.forune.rabbit.app.camerasanddoors.domain.repository

import com.forune.rabbit.app.camerasanddoors.domain.model.Door
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun downloadDoors(): List<Door>

    fun loadDoors(): Flow<List<Door>>

    suspend fun renameDoor(door: Door)

    suspend fun addDoorToFavorites(door: Door)
}