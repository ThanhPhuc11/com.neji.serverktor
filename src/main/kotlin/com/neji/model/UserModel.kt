package com.neji.model

import com.neji.dto.UserDto
import org.jetbrains.exposed.sql.ResultRow

@kotlinx.serialization.Serializable
data class UserModel(
    var id: Int? = null,
    var name: String? = null,
    var age: Int? = null,
    var email: String? = null,
    var password: String? = null,
    var firstname: String? = null,
    var lastname: String? = null,
    var phone: String? = null,
    var avatar: String? = null,
    var lat: Double? = null,
    var long: Double? = null
) {
    constructor(it: ResultRow) : this(
        it[UserDto.id],
        it[UserDto.name],
        it[UserDto.age],
        it[UserDto.email],
        it[UserDto.password],
        it[UserDto.firstname],
        it[UserDto.lastname],
        it[UserDto.phone],
        it[UserDto.avatar],
        it[UserDto.lat],
        it[UserDto.long]
    )
}
