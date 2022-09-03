val ktor_version: String by project
val kotlin_version: String by project
val logback_version: String by project
val firebaseAdminVersion: String by project

plugins {
    application
    kotlin("jvm") version "1.6.20"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.6.20"
    id("com.github.johnrengelman.shadow") version "7.0.0"

//    id("org.springframework.boot") version "2.6.6"
//    id("io.spring.dependency-management") version "1.0.11.RELEASE"
//    kotlin("plugin.spring") version "1.6.10"
}

group = "com.neji"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11
application {
    mainClass.set("io.ktor.server.netty.EngineMain")

    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral()
    maven {
        url = uri("https://maven.pkg.jetbrains.space/public/p/ktor/eap")
        url = uri("https://jitpack.io")
        maven(url = "https://repo.spring.io/snapshot")

//        maven ( url = "http://kotlin.bintray.com/ktor")
        maven (url = "https://dl.bintray.com/kotlin/kotlinx" )
    }
}

dependencies {
    implementation("io.ktor:ktor-server-content-negotiation-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-core-jvm:$ktor_version")
    implementation("io.ktor:ktor-serialization-kotlinx-json-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-call-logging-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-auth-jwt:$ktor_version")
    implementation("io.ktor:ktor-server-host-common-jvm:$ktor_version")
    implementation("io.ktor:ktor-server-netty-jvm:$ktor_version")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("org.jetbrains.exposed:exposed-core:0.37.3")
    implementation("org.jetbrains.exposed:exposed-dao:0.37.3")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.37.3")
    implementation("org.mariadb.jdbc:mariadb-java-client:3.0.4")
    testImplementation("io.ktor:ktor-server-tests-jvm:$ktor_version")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

//    implementation("com.github.papsign:Ktor-OpenAPI-Generator:-SNAPSHOT")

    implementation("io.insert-koin:koin-core:3.2.0-beta-1")
    implementation("io.insert-koin:koin-ktor:3.2.0-beta-1")
    implementation("io.insert-koin:koin-logger-slf4j:3.2.0-beta-1")

    //webSocket
    implementation("io.ktor:ktor-server-websockets:$ktor_version")

    // Ktor client
    implementation("io.ktor:ktor-client-core:$ktor_version")
    implementation("io.ktor:ktor-client-cio:$ktor_version")
    implementation("io.ktor:ktor-client-content-negotiation:2.1.0")
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.0.0-beta-1")

    // Firebase admin
    implementation ("com.google.firebase:firebase-admin:9.0.0")
}

//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf("-Xjsr305=strict")
//        jvmTarget = "11"
//    }
//}
//
//tasks.withType<Test> {
//    useJUnitPlatform()
//}
//tasks.jar {
//    manifest {
//        attributes["Main-Class"] = "ApplicationKt"
//    }
//    configurations["compileClasspath"].forEach { file: File ->
//        from(zipTree(file.absoluteFile))
//    }
//    duplicatesStrategy = DuplicatesStrategy.INCLUDE
//}

tasks {
    shadowJar {
        manifest {
            attributes(Pair("Main-Class", "io.ktor.server.netty.EngineMain"))
        }
    }
}