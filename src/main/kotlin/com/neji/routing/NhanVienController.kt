package com.neji.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.nhanvienController() {
    route("api/nhanvien") {
        get {
            call.parameters["id"]?.let {
                call.respond(mapOf("token" to it))
                return@get
            }
            call.respond(mapOf("token" to "haha"))
        }
    }
}