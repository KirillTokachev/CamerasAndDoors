package com.forune.rabbit.app.camerasanddoors.domain.model

data class Camera(
    val id: Int,
    var name: String,
    val snapshot: String,
    val room: String?,
    val favorites: Boolean,
    val rec: Boolean
)
