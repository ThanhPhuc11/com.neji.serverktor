package com.neji.routing

import com.neji.service.UserService
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.userController() {
    val service: UserService by inject(UserService::class.java)
    route("api/user") {
        get {
            val list = service.getUser(call.parameters["id"])
            call.respond(list)
        }
    }
}