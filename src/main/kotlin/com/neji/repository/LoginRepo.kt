package com.neji.repository

import com.neji.dto.UserDto
import com.neji.model.NhanVien
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.insert
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.transactions.transaction

fun getUserById(id: Int) = transaction {
    addLogger(StdOutSqlLogger)
    UserDto.select { UserDto.id eq id }.map { NhanVien(id = it[UserDto.id], name = it[UserDto.name]) }
}.toMutableList()

fun createNV(nv: NhanVien) = transaction {
    addLogger(StdOutSqlLogger)
    UserDto.insert {
        it[name] = nv.name ?: ""
        it[age] = nv.age ?: 0
    } get UserDto.id
}