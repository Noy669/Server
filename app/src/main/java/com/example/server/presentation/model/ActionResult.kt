package com.example.server.presentation.model

sealed class ActionResult<T>() {
    data class SUCCESS<T>(val message: String, val data: T?) : ActionResult<T>()
    data class ERROR<T>(val message: String) : ActionResult<T>()
}


