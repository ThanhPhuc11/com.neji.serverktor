package com.neji.plugins

import com.neji.CustomKoinPlugin
import com.neji.di.helloAppModule
import io.ktor.server.application.*
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