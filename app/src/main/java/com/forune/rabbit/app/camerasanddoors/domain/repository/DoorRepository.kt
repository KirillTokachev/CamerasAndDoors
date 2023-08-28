package com.forune.rabbit.app.camerasanddoors.domain.repository

import com.forune.rabbit.app.camerasanddoors.domain.model.Door

interface DoorRepository {

    fun downloadDoors(): List<Door>

    fun loadDoors(): List<Door>

    fun rename(newName: String)
}