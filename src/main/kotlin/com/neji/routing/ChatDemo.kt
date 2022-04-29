package com.neji.routing

import io.ktor.server.routing.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*

fun Route.chatController() {
    webSocket("chat") {
        send("Please enter your name")
        for (frame in incoming) {
            when (frame) {
                is Frame.Text -> {
                    val receivedText = frame.readText()
                    if (receivedText.equals("bye", ignoreCase = true)) {
                        close(CloseReason(CloseReason.Codes.NORMAL, "Client said BYE"))
                    } else {
                        send(Frame.Text("Hi, $receivedText!"))
                    }
                }
                else -> {}
            }
        }
    }
}