package com.neji.utils

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import io.ktor.server.application.*
import java.util.*

class JwtUtils {
    fun genToken(application: Application, id: Int): String {
        val secret = application.environment.config.property("jwt.secret").getString()
        val issuer = application.environment.config.property("jwt.issuer").getString()
        val audience = application.environment.config.property("jwt.audience").getString()
        val myRealm = application.environment.config.property("jwt.realm").getString()

        return JWT.create()
            .withAudience(audience)
            .withIssuer(issuer)
//            .withClaim("name", user.name)
            .withClaim("id", id)
            .withExpiresAt(Date(System.currentTimeMillis() + 86400000))
            .sign(Algorithm.HMAC256(secret))
    }
}