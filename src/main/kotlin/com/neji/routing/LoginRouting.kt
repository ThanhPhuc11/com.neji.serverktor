package com.neji.routing

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.neji.model.NhanVien
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import java.util.*

fun Application.loginRouting() {
    val secret = environment.config.property("jwt.secret").getString()
    val issuer = environment.config.property("jwt.issuer").getString()
    val audience = environment.config.property("jwt.audience").getString()
    val myRealm = environment.config.property("jwt.realm").getString()

    routing {
        post ("/api/login") {
            val user = call.receive<NhanVien>()
            val token = JWT.create()
                .withAudience(audience)
                .withIssuer(issuer)
                .withClaim("name", user.name)
                .withExpiresAt(Date(System.currentTimeMillis() + 60000))
                .sign(Algorithm.HMAC256(secret))

            call.respond(hashMapOf("token" to token))
        }
    }

    transaction {
////        addLogger(StdOutSqlLogger)
        for (user1 in user.selectAll()) {
            println("hahahahahahahahaha ${user1[user.name]}")
        }
    }
}

object user: Table() {
    val id = integer("id")
    val name = varchar("name", 50)
}