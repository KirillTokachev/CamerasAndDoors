package com.forune.rabbit.app.camerasanddoors.domain.model

data class Door(
    val id: Int,
    val name: String,
    val room: String?,
    val favorites: Boolean
)
