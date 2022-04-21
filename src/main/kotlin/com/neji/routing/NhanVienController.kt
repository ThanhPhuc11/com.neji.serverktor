package com.neji.routing

import com.neji.service.UserService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.userController() {
    route("api/user") {
        get {
            val list = UserService.getUser(call.parameters["id"])
            call.respond(list)
        }
    }
}