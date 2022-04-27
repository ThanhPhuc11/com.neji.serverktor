package com.neji.routing

import com.neji.service.UserService
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.userAuthController() {
    val service: UserService by inject(UserService::class.java)
    authenticate("auth-jwt") {
        get("/authen/user") {
            val principal = call.principal<JWTPrincipal>()
            val id = principal!!.payload.getClaim("id").toString()
            val username = principal!!.payload.getClaim("name").asString()
            val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())
//            call.respondText("Hello, $id $username")

            val list = service.getUser(id)
            call.respond(list)
        }
    }
}