package com.neji.routing

import com.neji.service.FirebaseService
import io.ktor.server.routing.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import org.koin.java.KoinJavaComponent

fun Route.fcmController() {
    val service: FirebaseService by KoinJavaComponent.inject(FirebaseService::class.java)
    route("fcm") {
        get("test") {
            val status = service.getDataFromKtorClient()
            call.respond(status)
        }
//        service.getDataFromKtorClient()
    }
}

//fun sendNotification(httpClient: HttpClient, apiKey: String, notification: Notification): Response {
//    return try {
//        httpClient.post<String> {
//            url(BlogController.NOTIFICATIONS)
//            contentType(ContentType.Application.Json)
//            header("Authorization", "Basic $apiKey")
//            body = notification
//        }
//        GeneralResponse.success("Notification sent")
//    } catch (e: Exception) {
//        e.printStackTrace()
//        GeneralResponse.failed("Error occurred")
//    }
//}