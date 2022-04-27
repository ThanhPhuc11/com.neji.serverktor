package com.neji

import io.ktor.events.*
import io.ktor.events.EventDefinition
import io.ktor.server.application.*
import io.ktor.util.*
import org.koin.core.KoinApplication
import org.koin.core.context.GlobalContext.stopKoin
import org.koin.core.context.startKoin

//import org.koin.core.context.GlobalContext.startKoin
//import org.koin.core.context.GlobalContext.stopKoin

val KApplicationStarted = EventDefinition<KoinApplication>()
val KApplicationStopPreparing = EventDefinition<KoinApplication>()
val KApplicationStopped = EventDefinition<KoinApplication>()
// Create a new custom application plugin
internal class CustomKoinPlugin(internal val koinApplication: KoinApplication) {
    // Implements ApplicationPlugin as a companion object.
    companion object Plugin : BaseApplicationPlugin<ApplicationCallPipeline, KoinApplication, CustomKoinPlugin> {
        // Creates a unique key for the plugin.
        override val key = AttributeKey<CustomKoinPlugin>("CustomKoinPlugin")

        // Code to execute when installing the plugin.
        override fun install(
            pipeline: ApplicationCallPipeline,
            configure: KoinApplication.() -> Unit
        ): CustomKoinPlugin {
            val monitor = pipeline.environment?.monitor
            val koinApplication = startKoin(appDeclaration = configure)
            if (monitor != null) {
                monitor.raise(KApplicationStarted, koinApplication)
                monitor.subscribe(ApplicationStopping) {
                    monitor.raise(KApplicationStopPreparing, koinApplication)
                    stopKoin()
                    monitor.raise(KApplicationStopped, koinApplication)
                }
            }
            return CustomKoinPlugin(koinApplication)
        }
    }
}