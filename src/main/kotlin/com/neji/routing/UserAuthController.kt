package com.neji.routing

import com.neji.model.UserModel
import com.neji.service.UserService
import com.neji.utils.JwtUtils
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent.inject

fun Route.userAuthController() {
    val service: UserService by inject(UserService::class.java)
    val jwtUtils: JwtUtils by inject(JwtUtils::class.java)
    route("user") {
        get("checkExistEmail") {
            val email = call.parameters["email"]
            call.respond(service.checkExisEmail(email))
        }

        post("register") {
            val userModel = call.receive<UserModel>()
            val id = service.registerUser(userModel)
            id?.let {
                val token = jwtUtils.genToken(this.context.application, it)
                call.respond(HttpStatusCode.Created, mapOf("token" to token))
            }
//            id?.let { call.respond(HttpStatusCode.Created, mapOf("id" to id)) }
        }

        get("getTokenById") {
            val id = call.parameters["id"]
            val token = jwtUtils.genToken(this.context.application, id!!.toInt())
            call.respond(mapOf("token" to token))
        }
    }

    authenticate("auth-jwt") {
        route("user") {
            get {
                val principal = call.principal<JWTPrincipal>()
                val id = principal!!.payload.getClaim("id").toString()
                val expiresAt = principal.expiresAt?.time?.minus(System.currentTimeMillis())

                val list = service.getUser(id)
                call.respond(list)
            }
        }
    }
}