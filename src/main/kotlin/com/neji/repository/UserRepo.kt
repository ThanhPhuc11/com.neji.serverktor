package com.neji.repository

import com.neji.dto.UserDto
import com.neji.model.UserModel
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepo {
    fun checkEmail(email: String) = transaction {
        addLogger(StdOutSqlLogger)
        UserDto.select { UserDto.email eq email }
            .map {
                UserModel(it[UserDto.id])
            }
    }

    fun createUser(user: UserModel) = transaction {
        addLogger(StdOutSqlLogger)
        UserDto.insert {
            it[name] = user.name ?: ""
            it[email] = user.email ?: ""
            it[password] = user.password ?: ""
        } get UserDto.id
    }

    fun getAllUser() = transaction {
        addLogger(StdOutSqlLogger)
        UserDto
            .selectAll()
            .map {
                UserModel(it[UserDto.id], it[UserDto.name], it[UserDto.age])
            }
    }

    fun getUserById(id: Int) = transaction {
        addLogger(StdOutSqlLogger)
        UserDto
            .select { UserDto.id eq id }
            .map {
                UserModel(it)
            }
    }.toMutableList()
}