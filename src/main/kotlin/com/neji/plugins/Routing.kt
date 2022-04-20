package com.neji.plugins

import com.neji.model.NhanVien
import io.ktor.client.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.http.content.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {
//    val listNV = mutableListOf<NhanVien>().apply {
//        add(NhanVien("Nguyen Van A", 19))
//        add(NhanVien("Nguyen Van B", 20))
//    }

    routing {
        get("/api/getList/{age}") {
//            call.respond(
//                HttpStatusCode.OK,
//                listNV.firstOrNull { it.age == (call.parameters["age"]?.toInt()) }?:"ko co"
//            )
        }
        // Static plugin. Try to access `/static/index.html`
        static("/static") {
            resources("static")
        }
    }
}
