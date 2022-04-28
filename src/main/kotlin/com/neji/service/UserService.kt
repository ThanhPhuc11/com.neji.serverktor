package com.neji.service

import com.neji.model.UserModel
import com.neji.repository.UserRepo
import io.ktor.http.*

class UserService(private val repo: UserRepo) {
    fun checkExisEmail(email: String?): Boolean {
        if (email.isNullOrBlank()) return true
        else {
            if (repo.checkEmail(email).isEmpty()) {
                return false
            }
            return true
        }
    }

    fun registerUser(userModel: UserModel): Int? {
        if (checkExisEmail(userModel.email)) return null
        if (isValidate(userModel.name, userModel.password)) {
            return repo.createUser(userModel)
        }
        return null
    }

    private fun isValidate(userName: String?, password: String?): Boolean {
        return !(userName == null || password == null)
    }

    fun getUser(id: String?): UserModel? {
        val paramId = try {
            id!!.toInt()
        } catch (_: Exception) {
            null
        }
        paramId?.let {
            return repo.getUserById(paramId).firstOrNull()
        }
        return null
    }

    fun updateUser(id: String?, userModel: UserModel): HttpStatusCode {
        getUser(id)?.let {
            userModel.id = id!!.toInt()
            if(repo.updateUser(userModel) == 1) {
                return HttpStatusCode.NoContent
            }
        }
        return HttpStatusCode.BadRequest
    }
}