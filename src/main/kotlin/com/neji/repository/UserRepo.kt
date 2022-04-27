package com.neji.repository

import com.neji.dto.UserDto
import com.neji.model.NhanVien
import org.jetbrains.exposed.sql.StdOutSqlLogger
import org.jetbrains.exposed.sql.addLogger
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.selectAll
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepo {
    fun getAllUser() = transaction {
        addLogger(StdOutSqlLogger)
        UserDto
            .selectAll()
            .map {
                NhanVien(it[UserDto.id], it[UserDto.name], it[UserDto.age])
            }
    }

    fun getUserById(id: Int) = transaction {
        addLogger(StdOutSqlLogger)
        UserDto
            .select { UserDto.id eq id }
            .map {
                NhanVien(it[UserDto.id], it[UserDto.name], it[UserDto.age])
            }
    }.toMutableList()
}