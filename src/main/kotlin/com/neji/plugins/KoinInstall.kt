package com.neji.plugins

import com.neji.CustomKoinPlugin
import io.ktor.server.application.*
import io.ktor.server.plugins.callloging.*
import io.netty.handler.codec.DefaultHeaders
import org.koin.core.logger.Level
import org.koin.logger.slf4jLogger

fun Application.koinInstall() {
//    install(DefaultHeaders)
//    install(CallLogging)
    install(CustomKoinPlugin) {
        slf4jLogger(Level.ERROR)
        modules(helloAppModule)
    }
}