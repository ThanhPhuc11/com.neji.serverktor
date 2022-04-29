package com.neji.plugins

import com.neji.routing.chatController
import com.neji.routing.loginController
import com.neji.routing.userController
import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        loginController()
        userController()
        chatController()
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
