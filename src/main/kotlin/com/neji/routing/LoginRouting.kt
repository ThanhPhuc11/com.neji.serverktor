package com.neji.routing

import com.neji.model.UserModel
import com.neji.service.UserService
import com.neji.utils.JwtUtils
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.koin.java.KoinJavaComponent

fun Route.loginController() {
    val service: UserService by KoinJavaComponent.inject(UserService::class.java)
    val jwtUtils: JwtUtils by KoinJavaComponent.inject(JwtUtils::class.java)

    route("authen") {
        post("login") {
            val user = call.receive<UserModel>()
            val id = service.getIdFromAuthen(user)
            val token = jwtUtils.genToken(this.context.application, id!!)

            call.respond(hashMapOf("token" to token))
        }
    }
}