package com.neji.dto

import org.jetbrains.exposed.sql.Table

object User : Table(name = "user") {
    val id = integer("id").autoIncrement()
    val name = varchar("name", 50)
    val age = integer("age")
}