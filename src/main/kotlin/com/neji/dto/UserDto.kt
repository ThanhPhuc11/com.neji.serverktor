package com.neji.dto

import org.jetbrains.exposed.sql.Table

object UserDto : Table(name = "user") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 255)
    val age = integer("age")
    val email = varchar("email", 255)
    val password = varchar("password", 255)
    val firstname = varchar("firstname", 255).nullable()
    val lastname = varchar("lastname", 255)
    val phone = varchar("phone", 255)
    val avatar = varchar("avatar", 255)
    val lat = double("lat")
    val long = double("long")
}