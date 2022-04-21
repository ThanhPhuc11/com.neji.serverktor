package com.neji

import io.ktor.server.application.*
import com.neji.plugins.*
import com.neji.routing.loginRouting
import org.jetbrains.exposed.sql.Database

fun main(args: Array<String>): Unit =
    io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // application.conf references the main function. This annotation prevents the IDE from marking it as unused.
fun Application.module() {
    Database.connect(
        "jdbc:mariadb://database-aws-test-1.cnc3ohcvl0tr.ap-southeast-1.rds.amazonaws.com:3306/mydbtest?useUnicode=no&characterEncoding=UTF-8&useLegacyDatetimeCode=false",
        driver = "org.mariadb.jdbc.Driver", user = "admin", password = "12345678"
    )
    configureRouting()
    configureSerialization()
    configureMonitoring()
    configureSecurity()
//    loginRouting()
}
