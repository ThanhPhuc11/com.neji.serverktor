package com.neji.repository

import com.neji.model.NhanVien
import com.neji.routing.User
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun getUserById(id: Int) = transaction {
    addLogger(StdOutSqlLogger)
    User.select { User.id eq id }.map { NhanVien(id = it[User.id], name = it[User.name]) }
}.toMutableList()

fun createNV(nv: NhanVien) = transaction {
    addLogger(StdOutSqlLogger)
    User.insert {
        it[name] = nv.name ?: ""
    } get User.id
}