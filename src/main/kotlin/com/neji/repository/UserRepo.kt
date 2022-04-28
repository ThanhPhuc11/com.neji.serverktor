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
                UserModel(it)
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

    fun updateUser(userModel: UserModel) = transaction {
        addLogger(StdOutSqlLogger)
        UserDto.update({ UserDto.id eq userModel.id!! }) {
//            it[firstname] = userModel.firstname
            userModel.firstname?.let { it2 -> it[firstname] = it2 }
            userModel.lastname?.let { it2 -> it[lastname] = it2 }
            userModel.phone?.let { it2 -> it[phone] = it2 }
            userModel.avatar?.let { it2 -> it[avatar] = it2 }
            userModel.lat?.let { it2 -> it[lat] = it2 }
            userModel.long?.let { it2 -> it[long] = it2 }
        }
    }
}